package es.upm.oeg.lab.modelers;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.lab.helpers.FilesHelper;
import es.upm.oeg.lab.helpers.StorageHelper;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.feature.Word2Vec;
import org.apache.spark.mllib.feature.Word2VecModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 30/10/15.
 */
public class Word2VecModeler extends ROModeler {

    private static final Logger logger = LoggerFactory.getLogger(Word2VecModeler.class);

    private final JavaRDD<ResearchObject> ros;

    private Word2VecModel model;

    public Word2VecModeler(JavaRDD<ResearchObject> ros) {
        this.ros = ros;
    }

    public Word2VecModel build(int vectorSize){

        JavaRDD<List<String>> input = ros.map(ro -> ro.getBagOfWords().stream().map(w -> w.toLowerCase()).collect(Collectors.toList()));

        Word2Vec word2Vec = new Word2Vec();
        word2Vec.setVectorSize(vectorSize);


        this.model = word2Vec.fit(input);

        return model;
    }

    public static void save(Word2VecModel model, String name){
        FilesHelper.create(StorageHelper.DIRECTORY, name);
        model.save(sc.sc(),name);
    }

    public static Word2VecModel load(String name){
        return Word2VecModel.load(sc.sc(),name);
    }


}
