package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.lab.data.Item;
import es.upm.oeg.lab.data.Section;
import es.upm.oeg.lab.data.W2VModel;
import es.upm.oeg.lab.helpers.FileHelper;
import es.upm.oeg.lab.helpers.ResultHelper;
import es.upm.oeg.lab.helpers.StorageHelper;
import es.upm.oeg.lab.modelers.Word2VecModeler;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.feature.Word2VecModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.*;

/**
 * Created by cbadenes on 03/11/15.
 */
public class W2VBuilder {

    public static final Integer NUM_WORDS = 50;

    private static final String DB_TYPE = "w2v";

    private static final Logger logger = LoggerFactory.getLogger(W2VBuilder.class);

    public static W2VModel build(JavaRDD<Item> items, Section.Type sectionType, int vectorSize){

        Path modelPath = FileHelper.path(ResultHelper.DIRECTORY, "w2v."+ sectionType.id);

        Word2VecModel model;
        if (modelPath.toFile().exists()){
            logger.info("Reading W2V Model from existing file:" + modelPath.toString());
            model = Word2VecModeler.load(modelPath.toString());
        }else{

            // Check in DB for previously generated an empty model
            String key = sectionType.id;
            Optional<Object> data = StorageHelper.read(DB_TYPE, key);

            if (data.isPresent()){
                logger.warn("Vocabulary is empty (readed from DB).");
                return new W2VModel();
            }

            logger.info("Creating W2V Model for section: " + sectionType + " of items");
            JavaRDD<ResearchObject> ros = items.map(i -> ROBuilder.newInstance(i, sectionType)).cache();
            model = new Word2VecModeler(ros).build(vectorSize);
            // Save Model
            if (model != null) Word2VecModeler.save(model,modelPath.toString());
            else StorageHelper.save(DB_TYPE,key,true);
        }
        return new W2VModel(model);

    }

    public static Map<Section.Type,W2VModel> build(JavaRDD<Item> items, List<Section.Type> sectionTypes, int vectorSize){

        Map<Section.Type,W2VModel> models = new HashMap<>();

        // Create models for each section
        for (Section.Type sectionType : sectionTypes){

            W2VModel w2vModel = build(items, sectionType, vectorSize);

            // Set WordDistributions
            models.put(sectionType,w2vModel);
        }

        // Return models
        return models;
    }
}
