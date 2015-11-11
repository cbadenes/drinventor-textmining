package es.upm.oeg.lab;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.epnoi.matching.metrics.similarity.JensenShannonSimilarity;
import es.upm.oeg.lab.builders.*;
import es.upm.oeg.lab.comparators.SimilarityResultComparator;
import es.upm.oeg.lab.comparators.StringComparator;
import es.upm.oeg.lab.data.*;
import es.upm.oeg.lab.function.CombinationFunction;
import es.upm.oeg.lab.function.ModelSimilarityPairFunction;
import es.upm.oeg.lab.function.TuplePairFunction;
import es.upm.oeg.lab.helpers.ChartsHelper;
import es.upm.oeg.lab.helpers.FileHelper;
import es.upm.oeg.lab.helpers.SparkHelper;
import es.upm.oeg.lab.helpers.StorageHelper;
import es.upm.oeg.lab.log.DIMarkers;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.stat.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbadenes on 02/11/15.
 */
public class Analyzer {

    /***********************************************************************************
     * Parameters
     ***********************************************************************************/

    public static final String CONTENT_ANNOTATED_CORPUS    = "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf";

    public static final String CONTEXT_ANNOTATED_CORPUS    = "src/main/resources/siggraphpaperMetaFilenames.json";

    public static final int NUM_WORDS                      = 25;

    public static final int W2V_DIMENSION                  = 100;

    public static final int LDA_MAX_ITERATIONS             = 70;

    /***********************************************************************************
     ***********************************************************************************/

    private static final Logger logger = LoggerFactory.getLogger(Analyzer.class);

    public void analyze(String contentAnnotatedCorpus, String contextAnnotatedCorpus, Integer numWords, Integer w2vDim, Integer ldaMaxIterations ) throws IOException {

        Date time = new Date();
        FileHelper.create(DIMarkers.DIRECTORY);

        logger.info(DIMarkers.eval,
                "Starting analysis with: " +
                        "content-annotated-corpus='"+contentAnnotatedCorpus +"', " +
                        "context-annotated-corpus='"+contextAnnotatedCorpus +"', " +
                        "num-words='"+ numWords + "', " +
                        "w2v-dimension='"+w2vDim+"' and " +
                        "lda-max-iterations='"+ ldaMaxIterations + "'");

        /***********************************************************************************
         * Initializing Storage
         ***********************************************************************************/
        StorageHelper.createDB(StorageHelper.dbName(DocumentBuilder.DB_TYPE));
        StorageHelper.createDB(StorageHelper.dbName(ItemBuilder.DB_TYPE));
        StorageHelper.createDB(StorageHelper.dbName(ROBuilder.DB_TYPE));
        StorageHelper.createDB(StorageHelper.dbName(W2VModelBuilder.DB_TYPE));
        StorageHelper.createDB(StorageHelper.dbName(TopicModelBuilder.DB_TYPE));


        /***********************************************************************************
         * Harvesting
         ***********************************************************************************/
        Stream<Document> data       = CorpusBuilder.harvest(contentAnnotatedCorpus, contextAnnotatedCorpus);
        JavaRDD<Document> documents = SparkHelper.sc.parallelize(data.collect(Collectors.toList())).cache();
        JavaRDD<Part.Type> parts    = SparkHelper.sc.parallelize(Arrays.asList(Part.Type.values())).cache();

        /***********************************************************************************
         * Corpus Statistics
         ***********************************************************************************/

        // Size of corpus
        long contextSize = documents.count();
        logger.info(DIMarkers.corpus,"Context Annotated: " + contextSize);

        JavaRDD<Document> annotatedPapers = documents.filter(i -> i.isAnnotated()).cache();
        long contentSize = annotatedPapers.count();
        logger.info(DIMarkers.corpus,"Content Annotated: " + contentSize);

        // Error Articles
        JavaRDD<Document> errorPapers = annotatedPapers.filter(i -> !StringComparator.same(i.getRefPaper().getTitle(), i.getTitle())).cache();
        long errorSize = errorPapers.count();
        logger.info(DIMarkers.corpus,"With Error: " + errorSize);
        errorPapers.foreach(i -> logger.warn(DIMarkers.corpus,"Paper error: '" + i.getRefPaper().getFilename() + "' has context title: '" + i.getRefPaper().getTitle() + "' different from content title: '" + i.getTitle() + "'"));

        // Valid Articles
        JavaRDD<Document> corpus = annotatedPapers.subtract(errorPapers).cache();
        long validSize = corpus.count();
        logger.info(DIMarkers.corpus,"Used: " + validSize);

        // Items
        JavaRDD<Item> items = corpus.flatMap(d -> ItemBuilder.build(d, Arrays.asList(Part.Type.values())));

        // Research Objects
        JavaRDD<ResearchObject> ros = items.map(i -> ROBuilder.newInstance(i)).cache();

        // BarChart with number of annotations
        logger.debug("Drawing a barplot with annotated documents");
        List<ChartItem> sizeItems = Arrays.asList(new ChartItem[]{
                ChartItemBuilder.build("context","documents",contextSize),
                ChartItemBuilder.build("content","documents",contentSize),
                ChartItemBuilder.build("error","documents",errorSize),
                ChartItemBuilder.build("correct","documents",validSize)
        });
        ChartsHelper.newBarPlot("corpus","Number of annotated documents",sizeItems);

        /***********************************************************************************
         * Context Statistics
         ***********************************************************************************/
        // Categories in corpus
        JavaPairRDD<String, Integer> categories = corpus.mapToPair(i -> new Tuple2<String, Integer>(i.getRefPaper().getDomain(), 1)).reduceByKey((a, b) -> a + b).cache();
        categories.foreach(t -> logger.info(DIMarkers.categories, "Category: '" + t._1() + "' in " + t._2() + " articles"));

        // Pie Chart with Categories
        logger.debug("Drawing a piechart with categories");
        List<ChartItem> categoryChartItems = categories.map(c -> ChartItemBuilder.build(c._1(), "", c._2())).collect();
        ChartsHelper.newPieChart("categories-context","Classification of documents by categories according to context annotations", categoryChartItems);


        /***********************************************************************************
         * Content Statistics
         ***********************************************************************************/

        // Statistics by document
        JavaRDD<Summary> summaries = items.map(i -> SummaryBuilder.newInstance(i)).cache();
        summaries.foreach(s -> logger.info(DIMarkers.stats, s.toString()));

        // Statistics by section
        JavaRDD<NlpSummary> nlpSummaries = summaries.flatMap(s -> s.getSections()).cache();


        // Correlation
        List<Tuple2<Part.Type, Part.Type>> sectionsCombined = CombinationFunction.combine(parts).collect();

        for (Tuple2<Part.Type, Part.Type> combination: sectionsCombined){
            String s1 = combination._1().id;
            String s2 = combination._2().id;

            try{
                // Sentences Level
                JavaRDD<Double> sent1 = nlpSummaries.filter(s -> s.getLabel().equalsIgnoreCase(s1)).map(s -> Double.valueOf(s.getNumSentences())).cache();
                JavaRDD<Double> sent2 = nlpSummaries.filter(s -> s.getLabel().equalsIgnoreCase(s2)).map(s -> Double.valueOf(s.getNumSentences())).cache();
                logger.info(DIMarkers.stats,"Sentences Correlation '"+ s1+"' and '" + s2 + "': pearson="+ Statistics.corr(sent1, sent2, "pearson") +", spearman="+Statistics.corr(sent1, sent2, "spearman"));
            } catch (Exception e){
                logger.error("Error calculating correlation sentences from "+ s1 + " and " + s2);
            }

            try{
                // Token Level
                JavaRDD<Double> sent1 = nlpSummaries.filter(s -> s.getLabel().equalsIgnoreCase(s1)).map(s -> Double.valueOf(s.getNumTokens())).cache();
                JavaRDD<Double> sent2 = nlpSummaries.filter(s -> s.getLabel().equalsIgnoreCase(s2)).map(s -> Double.valueOf(s.getNumTokens())).cache();
                logger.info(DIMarkers.stats,"Token Correlation '"+ s1+"' and '" + s2 + "': pearson="+ Statistics.corr(sent1, sent2, "pearson") +", spearman="+Statistics.corr(sent1, sent2, "spearman"));
            } catch (Exception e){
                logger.error("Error calculating correlation tokens from "+ s1 + " and " + s2);
            }

            try{
                // Word Level
                JavaRDD<Double> sent1 = nlpSummaries.filter(s -> s.getLabel().equalsIgnoreCase(s1)).map(s -> Double.valueOf(s.getNumWords())).cache();
                JavaRDD<Double> sent2 = nlpSummaries.filter(s -> s.getLabel().equalsIgnoreCase(s2)).map(s -> Double.valueOf(s.getNumWords())).cache();
                logger.info(DIMarkers.stats,"Word Correlation '"+ s1+"' and '" + s2 + "': pearson="+ Statistics.corr(sent1, sent2, "pearson") +", spearman="+Statistics.corr(sent1, sent2, "spearman"));
            } catch (Exception e){
                logger.error("Error calculating correlation words from "+ s1 + " and " + s2);
            }

            try{
                // Lemma Level
                JavaRDD<Double> sent1 = nlpSummaries.filter(s -> s.getLabel().equalsIgnoreCase(s1)).map(s -> Double.valueOf(s.getNumLemmas())).cache();
                JavaRDD<Double> sent2 = nlpSummaries.filter(s -> s.getLabel().equalsIgnoreCase(s2)).map(s -> Double.valueOf(s.getNumLemmas())).cache();
                logger.info(DIMarkers.stats,"Lemma Correlation '"+ s1+"' and '" + s2 + "': pearson="+ Statistics.corr(sent1, sent2, "pearson") +", spearman="+Statistics.corr(sent1, sent2, "spearman"));
            } catch (Exception e){
                logger.error("Error calculating correlation lemmas from "+ s1 + " and " + s2);
            }

        }

        // Boxplot with NLP Statistics by text element
        ChartsHelper.newBoxPlot("num-sentences", "Boxplot of number of sentences by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumSentences())).collect());
        ChartsHelper.newBoxPlot("num-tokens", "Boxplot of number of tokens by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumTokens())).collect());
        ChartsHelper.newBoxPlot("num-words", "Boxplot of number of words by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumWords())).collect());
        ChartsHelper.newBoxPlot("num-lemmas", "Boxplot of number of lemmas by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumLemmas())).collect());
        ChartsHelper.newBoxPlot("num-in", "Boxplot of number of IN by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumIN())).collect());
        ChartsHelper.newBoxPlot("num-jj", "Boxplot of number of JJ by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumJJ())).collect());
        ChartsHelper.newBoxPlot("num-nn", "Boxplot of number of NN by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumNN())).collect());
        ChartsHelper.newBoxPlot("num-nnp", "Boxplot of number of NNP by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumNNP())).collect());
        ChartsHelper.newBoxPlot("num-nnps", "Boxplot of number of NNPS by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumNNPS())).collect());
        ChartsHelper.newBoxPlot("num-rb", "Boxplot of number of RB by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumRB())).collect());
        ChartsHelper.newBoxPlot("num-rp", "Boxplot of number of RP by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumRP())).collect());
        ChartsHelper.newBoxPlot("num-vb", "Boxplot of number of VB by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumVB())).collect());
        ChartsHelper.newBoxPlot("num-vbd", "Boxplot of number of VBD by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumVBD())).collect());
        ChartsHelper.newBoxPlot("num-vbn", "Boxplot of number of VBN by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumVBN())).collect());
        ChartsHelper.newBoxPlot("num-vbp", "Boxplot of number of VBP by sections of a document", nlpSummaries.map(s -> ChartItemBuilder.build(s.getName(), s.getLabel(), s.getNumVBP())).collect());


        /***********************************************************************************
         * Representational Models
         ***********************************************************************************/

        // Distributional Models
        Map<String, W2VModel> w2vModels = new HashMap<>();
        // Topic Models
        Map<String, TopicModel> topicModels = new HashMap<>();

        // -> for each section in a separated way
        for (Part.Type section: Part.Type.values()){

            JavaRDD<ResearchObject> subset = ros.filter(ro -> ro.getUrl().equalsIgnoreCase(section.id)).cache();

            W2VModel w2vModel = W2VModelBuilder.newInstance(section.id,subset, numWords);
            w2vModels.put(section.id,w2vModel);

            TopicModel topicModel = TopicModelBuilder.build(subset, ldaMaxIterations);
            topicModels.put(section.id, topicModel);

            //Chart with this topic Model
            List<ChartItem> topicItems = topicModel.getTopics(numWords).stream().flatMap(t -> t.getWords().stream().map(w -> ChartItemBuilder.build(w._1(), t.getId(), w._2()))).collect(Collectors.toList());
            ChartsHelper.newBubbles("topics-"+section.id,"Distribution of topics based on the '" + section.id + "' content",topicItems);

        }

        // -> for all sections together
        JavaRDD<ResearchObject> subset = ros.filter(ro -> !ro.getUrl().equalsIgnoreCase(Part.Type.FULL.id));
        TopicModel topicModel = TopicModelBuilder.build(subset, ldaMaxIterations);
        topicModels.put("all", topicModel);

        //Chart with this topic Model
        List<ChartItem> topicItems = topicModel.getTopics(numWords).stream().flatMap(t -> t.getWords().stream().map(w -> ChartItemBuilder.build(w._1(), t.getId(), w._2()))).collect(Collectors.toList());
        ChartsHelper.newBubbles("topics-all","Distribution of topics considering all sections as corpus",topicItems);


        // ResearchObjects as modeled item for these models
        JavaRDD<ModeledItem> modeledROS = ros.
                map(ro -> ModeledItemBuilder.build(
                        ro.getSource().getUri(),
                        ro.getUrl(),
                        ro.getMetainformation().getDescription(),
                        topicModels.get(ro.getUrl()).distributionOf(ro)
                )).
                cache();

        /***********************************************************************************
         * ANALYSIS 1 :: Distance between sections and the identified category for that document
         ***********************************************************************************/

        // One modeledItem for each categories and section
        List<ModeledItem> modeledCategories = categories.
                map(t -> t._1()).
                cartesian(parts).
                collect().
                stream().
                map(t -> ModeledItemBuilder.build(
                        t._1(),
                        t._2().id,
                        t._1(),
                        w2vModels.get(t._2().id).find(t._1(), numWords),
                        topicModels.get(t._2().id).getTopics(numWords)
                )).
                collect(Collectors.toList());

        // Charts with category distributional representation by section
        modeledCategories.forEach(m -> ChartsHelper.newTreeMap("w2v-" + m.getId() + "-" + m.getLabel(), "Related words of '"+m.getId() + "' based on the W2V model built from the '" + m.getLabel() +"' content",m.getWordDistribution().getWords().stream().map(t -> ChartItemBuilder.build(t._1(), "", t._2())).collect(Collectors.toList())));


        // Calculate similarities between ROs and Categories based on these models
        JavaRDD<ModeledItem> modeledCategoriesRDD = SparkHelper.sc.parallelize(modeledCategories).cache();


        JavaPairRDD<ModeledItem, SimilarityResult> similarities = modeledROS.cartesian(modeledCategoriesRDD).
                filter(t -> t._1().getLabel().equalsIgnoreCase(t._2().getLabel())).
                mapToPair(new ModelSimilarityPairFunction()).
                cache();

        JavaRDD<SimilarityResult> mostSimilar = similarities.
                reduceByKey((a, b) -> SimilarityResultComparator.mostSimilar(a, b)).
                map(t -> t._2()).
                cache();

        // Evaluate Results

        for (String category: categories.map(t -> t._1()).collect()){

            JavaRDD<SimilarityResult> inCategory = mostSimilar.
                    filter(t -> t.getItem1().getCategory().equalsIgnoreCase(category) || t.getItem2().getId().equalsIgnoreCase(category)).
                    cache();

            List<ChartItem> listValues = new ArrayList<>();
            for (Part.Type section: Part.Type.values()){

                JavaRDD<SimilarityResult> inSection = inCategory.filter(t -> t.getItem1().getLabel().equalsIgnoreCase(section.id)).cache();


                Double truePositives  = Double.valueOf(inSection.filter(s -> s.getItem1().getCategory().equalsIgnoreCase(s.getItem2().getCategory())).count());
                Double falsePositives = Double.valueOf(inSection.filter(s -> s.getItem2().getCategory().equalsIgnoreCase(category)).filter(s -> !s.getItem1().getCategory().equalsIgnoreCase(category)).count());
                Double falseNegatives = Double.valueOf(inSection.filter(s -> !s.getItem2().getCategory().equalsIgnoreCase(category)).filter(s -> s.getItem1().getCategory().equalsIgnoreCase(category)).count());


                Double precision;
                Double recall;
                Double fmeasure;

                try{precision   = truePositives  / (truePositives + falsePositives);}catch (ArithmeticException e){precision = 0.0;}
                try{recall      = truePositives / (truePositives + falseNegatives);}catch (ArithmeticException e){recall = 0.0;}
                try{fmeasure    = 2 * ((precision * recall) / (precision + recall));}catch (ArithmeticException e){ fmeasure = 0.0;}

                if (precision.isNaN()) precision = 0.0;
                if (recall.isNaN()) recall = 0.0;
                if (fmeasure.isNaN()) fmeasure = 0.0;

                logger.info(DIMarkers.eval,"Eval Results for Category='"+ category+"' in section='"+section.id+"' => " +
                        "truePositives="+truePositives+", falsePositives="+falsePositives+", and falseNegatives="+falseNegatives + " => " +
                        "precision="+precision+", recall="+recall + ", fmeasure="+fmeasure);

                listValues.add(ChartItemBuilder.build("precision",section.id,precision));
                listValues.add(ChartItemBuilder.build("recall",section.id,recall));
                listValues.add(ChartItemBuilder.build("fmeasure",section.id,fmeasure));
            }

            // Chart with eval results
            ChartsHelper.newStacked("eval-"+category,"Evaluation results for category '"+category+"'",listValues);

        }

        /***********************************************************************************
         * ANALYSIS 2 :: Network of documents based on similarity for each section
         ***********************************************************************************/

        for (Part.Type section : Part.Type.values()){

            JavaRDD<ModeledItem> rosInSection = modeledROS.filter(ro -> ro.getLabel().equalsIgnoreCase(section.id));

            JavaRDD<EdgeItem> edges = CombinationFunction.
                    combine(rosInSection).
                    filter(t -> t._1().getTopicDistribution().length == t._2().getTopicDistribution().length).
                    map(t -> NetworkItemBuilder.newEdge(t._1().getId(), t._2().getId(), JensenShannonSimilarity.apply(t._1().getTopicDistribution(), t._2().getTopicDistribution()))).
                    filter(n -> n.getWeight() > 0.5).
                    cache();

            Map<String, Integer> nodesWeight = edges.flatMap(t -> Arrays.asList(new Tuple2[]{new Tuple2(t.getSource(), 1), new Tuple2(t.getTarget(), 2)})).
                    mapToPair(t -> new TuplePairFunction().call(t)).reduceByKey((a, b) -> (Integer) a + (Integer) b).collectAsMap();

            List<NodeItem> nodes = rosInSection.map(m -> NetworkItemBuilder.newNode(m.getId(), nodesWeight.get(m.getId()))).collect();

            logger.info("Drawing documents network for section '" + section + "'");
            ChartsHelper.newNetwork("network-"+section.id,"Network of documents based on similarities using only the '" + section+ "' sections",nodes,edges.collect());

        }


        /***********************************************************************************
         * Chart Report
         ***********************************************************************************/

        // Charts report
        ChartsHelper.report();

        /***********************************************************************************
         * Backup Data
         ***********************************************************************************/
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd-hhmmss");
        String testId = "test-"+dt.format(time);
        FileHelper.copyFolder(StorageHelper.DIRECTORY, testId);
        FileHelper.copyFolder(DIMarkers.DIRECTORY, testId);
        FileHelper.copyFolder(ChartsHelper.DIRECTORY, testId);
        logger.info("Backup created in: " + testId);

    }




    public static void main (String[] args) throws IOException {
        Analyzer analyzer = new Analyzer();

        try {
            analyzer.analyze(
                    CONTENT_ANNOTATED_CORPUS,
                    CONTEXT_ANNOTATED_CORPUS,
                    NUM_WORDS,
                    W2V_DIMENSION,
                    LDA_MAX_ITERATIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
