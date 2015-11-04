package es.upm.oeg.lab.data;

import lombok.Data;
import scala.Tuple2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class WordDistribution implements Serializable {

    String id;

    List<Tuple2<String, Double>> words = new ArrayList<>();

    public boolean isEmpty(){
        return words == null || words.isEmpty();
    }

    public WordDistribution add (String word, Double weight ){
        words.add(new Tuple2<>(word,weight));
        return this;
    }
}
