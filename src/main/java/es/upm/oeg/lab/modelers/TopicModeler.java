package es.upm.oeg.lab.modelers;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.epnoi.matching.metrics.domain.entity.ConceptualResource;
import es.upm.oeg.epnoi.matching.metrics.domain.entity.RegularResource;
import es.upm.oeg.epnoi.matching.metrics.domain.entity.Vocabulary;
import es.upm.oeg.epnoi.matching.metrics.domain.space.ConceptsSpace;
import es.upm.oeg.epnoi.matching.metrics.domain.space.TopicsSpace;
import es.upm.oeg.epnoi.matching.metrics.topics.LDASettings;
import es.upm.oeg.epnoi.matching.metrics.topics.search.LDASolution;
import es.upm.oeg.lab.data.TopicModel;
import es.upm.oeg.lab.helpers.StorageHelper;
import es.upm.oeg.lab.log.DIMarkers;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.linalg.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;
import scala.collection.JavaConversions;
import scala.collection.JavaConverters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cbadenes on 29/10/15.
 */
public class TopicModeler extends ROModeler{

    private static final Logger logger = LoggerFactory.getLogger(TopicModeler.class);

    private final ConceptsSpace conceptsSpace;
    private final String id;

    public TopicModeler(String id, JavaRDD<ResearchObject> ros){
        this.id = id;

        // Map of uri/title
        Map<String, String> roPairs = ros.mapToPair(roPair).collectAsMap();

        // Convert Research Objects to Regular Resources
        JavaRDD<RegularResource> regularResources = ros.map(rrParser);
        logger.info(DIMarkers.topic_model,"Number of Regular Resources: " + regularResources.count() + " in domain: '" + id + "'");

        // Convert Regular Resources to Conceptual Resources
        JavaRDD<ConceptualResource> conceptualResources = regularResources.map(crParser);
        logger.info(DIMarkers.topic_model,"Number of Conceptual Resources: " + regularResources.count() + " in domain: '" + id + "'");

        // Create the Concepts Space
        this.conceptsSpace = new ConceptsSpace(conceptualResources.rdd());
    }


    public TopicModel build(Integer maxIt){
        LDASettings.setMaxIterations(maxIt);

        logger.info("Learning Topic Model for '" + id + "' maxIt: " + maxIt);

        // Learn
        LDASolution settings = LDASettings.learn(conceptsSpace.featureVectors(), maxIt, maxIt);
        logger.info(DIMarkers.topic_model,"Topic Model for '" + id + "' learnt with: alpha=" + settings.getAlpha() + ", beta="+ settings.getBeta() + " and numTopics: " + settings.getTopics());

        // Build model
        TopicsSpace topicsSpace = new TopicsSpace(conceptsSpace);

        Map<Object, String> words               = JavaConverters.mapAsJavaMapConverter(conceptsSpace.vocabulary().wordsByKeyMap()).asJava();
        Tuple2<int[], double[]>[] topics        = topicsSpace.model().ldaModel().describeTopics(200);
        List<Tuple2<Object, Vector>> documents  = topicsSpace.model().ldaModel().topicDistributions().toJavaRDD().collect();
        List<Tuple2<Object, ConceptualResource>> resources = conceptsSpace.conceptualResourcesMap().toJavaRDD().collect();

        logger.info("Created topic model with " + documents.size() + " documents");
        TopicModel.Configuration configuration = new TopicModel.Configuration(LDASettings.topics(),LDASettings.alpha(), LDASettings.beta(), LDASettings.maxEvals(), LDASettings.maxEvals());
        return new TopicModel(id,configuration,documents,words,topics,resources);
    }

    public TopicModel build(Integer numTopics, Double alpha, Double beta, Integer maxIt){
        // Manual Configuration
        LDASettings.setTopics(numTopics);
        LDASettings.setAlpha(alpha);
        LDASettings.setBeta(beta);

        // Create the Topics Space
        return build(maxIt);
    }

}
