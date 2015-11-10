package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.lab.data.W2VModel;
import es.upm.oeg.lab.helpers.FileHelper;
import es.upm.oeg.lab.helpers.StorageHelper;
import es.upm.oeg.lab.log.DIMarkers;
import es.upm.oeg.lab.modelers.Word2VecModeler;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.feature.Word2VecModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Optional;

/**
 * Created by cbadenes on 03/11/15.
 */
public class W2VModelBuilder {

    private static final Logger logger = LoggerFactory.getLogger(W2VModelBuilder.class);

    public static final String DB_TYPE = "w2v";

    public static W2VModel newInstance(String id, JavaRDD<ResearchObject> ros, int vectorSize){

        String modelId = ros.first().getUrl();

        // Check if stored in DB
        Path modelPath = FileHelper.path(StorageHelper.DIRECTORY, "w2v."+ modelId);

        Word2VecModel model = null;
        if (modelPath.toFile().exists()){
            logger.info("Reading W2V Model from existing file:" + modelPath.toString());
            model = Word2VecModeler.load(modelPath.toString());
        }else{

            // Check in DB for previously generated an empty model
            Optional<Object> data = StorageHelper.read(DB_TYPE, modelId);

            if (data.isPresent()){
                logger.warn(DIMarkers.w2v_model,"Vocabulary is empty for section: '" + modelId + "' (read from DB).");
                return new W2VModel(id);
            }

            logger.info("Creating W2V Model for section: " + modelId + " of items");
            try{
                model = new Word2VecModeler(ros).build(vectorSize);
                // Save the model
                Word2VecModeler.save(model,modelPath.toString());
            }catch (IllegalArgumentException e){
                logger.warn(DIMarkers.w2v_model,"Vocabulary is empty for section: '" + modelId + "' (creation).");
                StorageHelper.save(DB_TYPE,modelId,true);
            }

        }

        return new W2VModel(id,model);
    }
}
