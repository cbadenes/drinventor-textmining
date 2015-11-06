package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.lab.data.Item;
import es.upm.oeg.lab.data.Section;
import es.upm.oeg.lab.data.TopicModel;
import es.upm.oeg.lab.helpers.StorageHelper;
import es.upm.oeg.lab.log.DIMarkers;
import es.upm.oeg.lab.modelers.TopicModeler;
import org.apache.spark.api.java.JavaRDD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by cbadenes on 03/11/15.
 */
public class TopicsBuilder {

    private static final Logger logger = LoggerFactory.getLogger(TopicsBuilder.class);

    public static final String DB_TYPE = "topics";

    public static TopicModel build(JavaRDD<Item> items, Section.Type sectionType, int maxIterations){

        String key = sectionType.id;

        Optional<Object> data = StorageHelper.read(DB_TYPE,key);

        if (data.isPresent()){
            logger.info("Topic model loaded from DB."+sectionType.id);
            return (TopicModel) data.get();
        }

        logger.info("Creating topic model from corpus based on " + sectionType.name().toString() + " ..");
        JavaRDD<ResearchObject> ros = items.filter(i -> !i.get(sectionType).isEmpty()).map(i -> ROBuilder.newInstance(i, sectionType));

        if (ros == null | ros.count() == 0){
            throw new IllegalArgumentException("Vocabulary is empty for section: " + sectionType);
        }

        TopicModeler modeler = new TopicModeler(sectionType.id,ros);

        TopicModel topicModel = modeler.build(maxIterations);

        StorageHelper.save(DB_TYPE,key,topicModel);

        return topicModel;
    }

    public static Map<Section.Type,TopicModel> build(JavaRDD<Item> items, List<Section.Type> sectionTypes, int maxIterations){

        Map<Section.Type,TopicModel> topicSpaces = new HashMap<>();

        for(Section.Type sectionType : sectionTypes){

            TopicModel model;
            try {
                model = build(items, sectionType, maxIterations);
            } catch (IllegalArgumentException e){
                logger.error(DIMarkers.topic_model,e.getMessage());
                model = new TopicModel();
            }

            topicSpaces.put(sectionType, model);
        }

        return topicSpaces;
    }
}
