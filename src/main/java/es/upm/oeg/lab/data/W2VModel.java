package es.upm.oeg.lab.data;

import es.upm.oeg.lab.helpers.StorageHelper;
import es.upm.oeg.lab.log.DIMarkers;
import org.apache.spark.mllib.feature.Word2VecModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by cbadenes on 03/11/15.
 */
public class W2VModel {

    private static final Logger logger = LoggerFactory.getLogger(W2VModel.class);

    private final Word2VecModel model;
    private final String id;

    public W2VModel(String id){
        this.id = id;
        this.model = null;
    }

    public W2VModel(String id,Word2VecModel model){
        this.id = id;
        this.model = model;
    }

    public WordDistribution find(String term, Integer num){
        // Get vector for categories
        WordDistribution wd = new WordDistribution();
        if (model != null){
            wd.setId(term);
            wd.setLabel(id);
            try{
                Tuple2<String, Object>[] synonyms = model.findSynonyms(term, num);
                for (Tuple2<String, Object> tuple: synonyms){
                    String word = tuple._1();
                    Double weight = (Double) tuple._2();
                    wd.add(word,weight);
                }
                logger.info(DIMarkers.w2v_model,"W2V Distribution of term: '"+ term + "' in '"+id+"':" + Arrays.asList(wd.getWords()));
            }catch (Exception e){
                logger.warn(e.getMessage() + " '" + id + "'");
                //TODO try again using synonyms from WordNet
            }
        }else{
            logger.info("Model is empty!");
        }
        return wd;
    }
}
