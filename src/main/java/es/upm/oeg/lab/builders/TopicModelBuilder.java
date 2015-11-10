package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.lab.data.TopicModel;
import es.upm.oeg.lab.helpers.StorageHelper;
import es.upm.oeg.lab.log.DIMarkers;
import es.upm.oeg.lab.modelers.TopicModeler;
import org.apache.spark.api.java.JavaRDD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by cbadenes on 03/11/15.
 */
public class TopicModelBuilder {

    private static final Logger logger = LoggerFactory.getLogger(TopicModelBuilder.class);

    public static final String DB_TYPE = "topics";


    public static TopicModel build(JavaRDD<ResearchObject> ros, int maxIterations){

        String modelId = ros.first().getUrl();

        Optional<Object> data = StorageHelper.read(DB_TYPE,modelId);

        if (data.isPresent()){
            logger.info("Topic model loaded from DB."+modelId);
            return (TopicModel) data.get();
        }

        logger.info("Creating topic model from corpus based on '" + modelId + "' ..");

        TopicModeler modeler = new TopicModeler(modelId,ros);

        TopicModel topicModel = null;
        try{
            topicModel = modeler.build(maxIterations);
        }catch (Exception e){
            logger.warn(DIMarkers.topic_model,"Vocabulary is empty for section: '" + modelId + "' (creation).");
            StorageHelper.save(DB_TYPE,modelId,true);
            topicModel = new TopicModel(modelId);
        }

        StorageHelper.save(DB_TYPE,modelId,topicModel);

        return topicModel;
    }


}
