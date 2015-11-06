package es.upm.oeg.lab;

import es.upm.oeg.lab.builders.*;
import es.upm.oeg.lab.comparators.StringComparator;
import es.upm.oeg.lab.data.*;
import es.upm.oeg.lab.helpers.FileHelper;
import es.upm.oeg.lab.helpers.SparkHelper;
import es.upm.oeg.lab.helpers.StorageHelper;
import es.upm.oeg.lab.log.DIMarkers;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.stat.MultivariateStatisticalSummary;
import org.apache.spark.mllib.stat.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 02/11/15.
 */
public class Analyzer {

    /***********************************************************************************
     * Parameters
     ***********************************************************************************/

    private static final String CONTENT_ANNOTATED_CORPUS    = "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf-sentAnalysis";

    private static final String CONTEXT_ANNOTATED_CORPUS    = "src/main/resources/siggraphpaperMetaFilenames.json";

    private static final int NUM_WORDS                      = 20;

    private static final int W2V_DIMENSION                  = 100;

    private static final int LDA_MAX_ITERATIONS             = 50;

    /***********************************************************************************
     ***********************************************************************************/

    private static final Logger logger = LoggerFactory.getLogger(Analyzer.class);

    public void analyze(String contentAnnotatedCorpus, String contextAnnotatedCorpus) throws IOException {

        FileHelper.create("logs");

        logger.info(DIMarkers.eval,"Starting analysis with content-annotated-corpus='"+CONTENT_ANNOTATED_CORPUS
                +"', context-annotated-corpus='"+CONTEXT_ANNOTATED_CORPUS +"', num-words='"+ NUM_WORDS +
                "', w2v-dimension='"+W2V_DIMENSION+"' and lda-max-iterations='"+ LDA_MAX_ITERATIONS + "'");

        /***********************************************************************************
         * Create internal storage
         ***********************************************************************************/
        StorageHelper.createDB(StorageHelper.dbName(ItemBuilder.DB_TYPE));
        StorageHelper.createDB(StorageHelper.dbName(ROBuilder.DB_TYPE));
        StorageHelper.createDB(StorageHelper.dbName(W2VBuilder.DB_TYPE));
        StorageHelper.createDB(StorageHelper.dbName(TopicsBuilder.DB_TYPE));


        /***********************************************************************************
         * Harvesting
         ***********************************************************************************/
        JavaRDD<Item> items = CorpusBuilder.harvestParallel(contentAnnotatedCorpus, contextAnnotatedCorpus).cache();

        /***********************************************************************************
         * Corpus Analysis
         ***********************************************************************************/

        // Size of corpus
        logger.info(DIMarkers.corpus,"Context Annotated: " + items.count());

        JavaRDD<Item> annotatedPapers = items.filter(i -> i.isAnnotated()).cache();
        logger.info(DIMarkers.corpus,"Content Annotated: " + annotatedPapers.count());

        // Error Articles
        JavaRDD<Item> errorPapers = annotatedPapers.filter(i -> !StringComparator.same(i.getRefPaper().getTitle(), i.getTitle())).cache();
        logger.info(DIMarkers.corpus,"With Error: " + errorPapers.count());
        errorPapers.foreach(i -> logger.warn(DIMarkers.corpus,"Paper error: '" + i.getRefPaper().getFilename() + "' has context title: '" + i.getRefPaper().getTitle() + "' different from content title: '" + i.getTitle() + "'"));

        // Valid Articles
        JavaRDD<Item> corpusItems = annotatedPapers.subtract(errorPapers).cache();
        logger.info(DIMarkers.corpus,"Used: " + corpusItems.count());

        /***********************************************************************************
         * Category Analysis
         ***********************************************************************************/
        // Categories in corpus
        JavaPairRDD<String, Integer> categoryFreq = corpusItems.mapToPair(i -> new Tuple2<String, Integer>(i.getRefPaper().getDomain(), 1)).reduceByKey((a, b) -> a + b).cache();
        categoryFreq.foreach(t -> logger.info(DIMarkers.categories,"Category: '" + t._1() + "' in " + t._2() + " articles"));

        /***********************************************************************************
         * Word Statistics
         ***********************************************************************************/

        // Statistics by document
        JavaRDD<Summary> summaries = corpusItems.map(i -> SummaryBuilder.newInstance(i)).cache();
        summaries.foreach(s -> logger.info(DIMarkers.stats,s.toString()));


        for(Section.Type section: Section.Type.values()){
            JavaRDD<NlpSummary> nlpSummaries = summaries.map(s -> s.getSections().stream().filter(p -> p.getId().equalsIgnoreCase(section.id)).findFirst().get()).cache();
            MultivariateStatisticalSummary nlpStats = Statistics.colStats(nlpSummaries.map(s -> s.toVector()).rdd());
            NlpSummary.log(nlpStats,section);
        }

        /***********************************************************************************
         * Models Creation
         ***********************************************************************************/

        // W2V Models
        Map<Section.Type, W2VModel> w2vModels = W2VBuilder.build(corpusItems, Arrays.asList(Section.Type.values()),W2V_DIMENSION);

        // Topic Models
        Map<Section.Type, TopicModel> topicModels = TopicsBuilder.build(corpusItems, Arrays.asList(Section.Type.values()), LDA_MAX_ITERATIONS);


        /***********************************************************************************
         * Similarity Analysis
         ***********************************************************************************/
        List<String> categories = categoryFreq.map(t -> t._1()).collect();
        // For each section:
        for(Section.Type sectionType : Section.Type.values()){

            // Get distances between categories's wordDistribution and topics for each section

            logger.info(DIMarkers.sim,"Calculate similarities based on " + sectionType);

            W2VModel w2vModel       = w2vModels.get(sectionType);
            TopicModel topicModel   = topicModels.get(sectionType);

            if (topicModel.isEmpty()){
                logger.warn(DIMarkers.sim,"Topic Model empty for section: " + sectionType);
                continue;
            }

            // Topics
            List<WordDistribution> topics = topicModel.getTopics(NUM_WORDS);
            logger.info(DIMarkers.sim,"Topics distribution in section: '"+sectionType+"': " + topics);


            Map<String,double[]> categoryDistr = new HashMap<>();
            for (String category: categories){
                // Get word distribution of category based on W2V model
                WordDistribution categoryWordDist = w2vModel.find(category, NUM_WORDS);

                if (categoryWordDist.isEmpty()){
                    logger.warn(DIMarkers.categories,"Category '" + category + "' not found in the w2v model of section: '" + sectionType+"'");
                    continue;
                }

                // Build a distribution of topics by category based on distances
                double[] categoryTopicDist = new double[topics.size()];

                for(int i = 0; i < topics.size() ; i++){
                    // distance between category distribution and topic distribution
                    double distance;
                    try{
                        distance = RankDistanceBuilder.distance(categoryWordDist, topics.get(i));
                        categoryTopicDist[i] = distance;
                    }catch (IllegalArgumentException e){
                        logger.warn(e.getMessage());
                        //TODO handle when category has not topic distribution
                        categoryTopicDist[i] = Double.MAX_VALUE;
                    }
                }

                // Normalize to Dirichlet distribution
                categoryDistr.put(category, DirichletBuilder.normalize(categoryTopicDist));
            }
            
            // Get similarities between documents and their category distributions
            for (String category: categoryDistr.keySet()){
                logger.info(DIMarkers.categories,"Category: '" + category + "' in section: '"+sectionType+"' distributed in topics: " + Arrays.toString(categoryDistr.get(category)));
            }

            JavaRDD<SimilarityResult> similarityResults = corpusItems.map(i -> new SimilarityResult(sectionType,i, SimilarityBuilder.similarity(topicModel.getDistribution(i), categoryDistr))).cache();

            //TODO: get similarities between documents

            // Print results
            similarityResults.foreach(s -> logger.info(DIMarkers.sim,s.toString()));

            /***********************************************************************************
             * Evaluation
             ***********************************************************************************/
            JavaRDD<Tuple2<String, String>> evalResults = similarityResults.map(r -> new Tuple2<String, String>(r.getItem().getRefPaper().getDomain(), r.getMostSimilar())).cache();


            for (String category : categories){
                // Precision
                long truePositives  = evalResults.filter(t -> t._1().equalsIgnoreCase(category)).filter(t -> t._2().equalsIgnoreCase(category)).count();
                long falsePositives = evalResults.filter(t -> !t._1().equalsIgnoreCase(category)).filter(t -> t._2().equalsIgnoreCase(category)).count();
                long falseNegatives = evalResults.filter(t -> t._1().equalsIgnoreCase(category)).filter(t -> !t._2().equalsIgnoreCase(category)).count();

                double precision    = 0.0;
                double recall       = 0.0;

                try{precision = Double.valueOf(truePositives)  / Double.valueOf(truePositives + falsePositives);}catch (ArithmeticException e){}
                try{recall = Double.valueOf(truePositives) / Double.valueOf(truePositives + falseNegatives);}catch (ArithmeticException e){}
                logger.info(DIMarkers.eval,"Evaluation of section: '"+ sectionType+"' for category: '"+category+"': Precision="+precision + ", Recall="+recall + "[truePositives="+truePositives + ", falsePositive="+falsePositives + ", falseNegatives="+ falseNegatives+"]");
            }
        }
    }




    public static void main (String[] args){
        Analyzer analyzer = new Analyzer();
        try {
            analyzer.analyze(CONTENT_ANNOTATED_CORPUS, CONTEXT_ANNOTATED_CORPUS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
