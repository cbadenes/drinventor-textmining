package es.upm.oeg.lab.builders;

import java.util.Arrays;

/**
 * Created by cbadenes on 03/11/15.
 */
public class DirichletBuilder {

    public static double[] normalize(double[] vector){
        double sum = Arrays.stream(vector).sum();
        return Arrays.stream(vector).map(v->v/sum).toArray();
    }
}
