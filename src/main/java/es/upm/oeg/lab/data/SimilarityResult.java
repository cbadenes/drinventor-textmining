package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cbadenes on 03/11/15.
 */
@Data
public class SimilarityResult implements Serializable{

    private ModeledItem item1;
    private ModeledItem item2;

    private double  similarity;
}
