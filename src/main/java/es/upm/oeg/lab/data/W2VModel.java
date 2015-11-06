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

    public W2VModel(){
        this.model = null;
    }

    public W2VModel(Word2VecModel model){
        this.model = model;
    }

    public WordDistribution find(String term, Integer num){
        // Get vector for categories
        WordDistribution wd = new WordDistribution();
        if (model != null){
            wd.setId(term);
            try{
                Tuple2<String, Object>[] synonyms = model.findSynonyms(term, num);
                for (Tuple2<String, Object> tuple: synonyms){
                    String word = tuple._1();
                    Double weight = (Double) tuple._2();
                    wd.add(word,weight);
                }
            }catch (Exception e){
                logger.warn(e.getMessage());
                //TODO try again using synonyms from WordNet


            }
            logger.info(DIMarkers.w2v_model,"W2V Distribution of term: '"+ term + "':" + Arrays.asList(wd.getWords()));
        }else{
            logger.info("Model is empty!");
        }
        return wd;
    }
}
