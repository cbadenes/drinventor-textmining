package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cbadenes on 07/11/15.
 */
@Data
public class ModeledItem implements Serializable{

    String id;
    String label;

    String category;
    WordDistribution wordDistribution;
    double[] topicDistribution;

}
