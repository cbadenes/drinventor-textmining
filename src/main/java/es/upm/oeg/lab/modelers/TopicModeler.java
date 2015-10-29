package es.upm.oeg.lab.modelers;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.epnoi.matching.metrics.domain.entity.ConceptualResource;
import es.upm.oeg.epnoi.matching.metrics.domain.entity.RegularResource;
import es.upm.oeg.epnoi.matching.metrics.domain.space.ConceptsSpace;
import es.upm.oeg.epnoi.matching.metrics.domain.space.TopicsSpace;
import es.upm.oeg.epnoi.matching.metrics.topics.LDASettings;
import es.upm.oeg.epnoi.matching.metrics.topics.search.LDASolution;
import es.upm.oeg.epnoi.ressist.parser.CRParser;
import es.upm.oeg.epnoi.ressist.parser.ROPair;
import es.upm.oeg.epnoi.ressist.parser.ROParser;
import es.upm.oeg.epnoi.ressist.parser.RRParser;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by cbadenes on 29/10/15.
 */
public class TopicModeler {

    private static final Logger logger = LoggerFactory.getLogger(TopicModeler.class);

    private static final ROParser roParser  = new ROParser();

    private static final ROPair roPair      = new ROPair();

    private static final RRParser rrParser  = new RRParser();

    private static final CRParser crParser  = new CRParser();


    private final ConceptsSpace conceptsSpace;

    public TopicModeler(String filesPattern){

        // Initialize Spark Context
        SparkConf conf = new SparkConf().
                setMaster("local[*]").
                setAppName("DrInventor").
                set("spark.executor.memory", "12g").
                set("spark.driver.maxResultSize","0");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Load directory as RDD of file (name,content)
        JavaPairRDD<String, String> input = sc.wholeTextFiles(filesPattern);

        // Convert files to Research Objects
        JavaRDD<ResearchObject> researchObjects = input.flatMap(roParser);
        logger.info("Number of Research Objects: " + researchObjects.count());

        // Map of uri/title
        Map<String, String> roPairs = researchObjects.mapToPair(roPair).collectAsMap();

        // Convert Research Objects to Regular Resources
        JavaRDD<RegularResource> regularResources = researchObjects.map(rrParser);
        logger.info("Number of Regular Resources: " + regularResources.count());

        // Convert Regular Resources to Conceptual Resources
        JavaRDD<ConceptualResource> conceptualResources = regularResources.map(crParser);
        logger.info("Number of Conceptual Resources: " + regularResources.count());

        // Create the Concepts Space
        this.conceptsSpace = new ConceptsSpace(conceptualResources.rdd());
    }


    public LDASolution learn(Integer maxEval, Integer maxIt){
        // LDA Optimization based on NSGA-III
        return LDASettings.learn(conceptsSpace.featureVectors(), maxEval, maxIt);
    }

    public TopicsSpace build(Integer maxIt){
        LDASettings.setMaxIterations(maxIt);
        return new TopicsSpace(conceptsSpace);
    }

    public TopicsSpace build(Integer numTopics, Double alpha, Double beta, Integer maxIt){
        // Manual Configuration
        LDASettings.setTopics(numTopics);
        LDASettings.setAlpha(alpha);
        LDASettings.setBeta(beta);

        // Create the Topics Space
        return build(maxIt);
    }

}
