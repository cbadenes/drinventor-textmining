package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.matching.metrics.similarity.JensenShannonSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cbadenes on 03/11/15.
 */
public class SimilarityBuilder {

    private static final Logger logger = LoggerFactory.getLogger(SimilarityBuilder.class);

    public static double similarity(double[] a, double[] b){
        double value = JensenShannonSimilarity.apply(a, b);
        logger.debug("similarity between: " + Arrays.toString(a) + " and " + Arrays.toString(b) + " is: " + value);
        return value;
    }

    public static Map<String,Double> similarity(double[] a, Map<String,double[]> c){
        Map<String,Double> similarities = new HashMap<>();
        for(String key: c.keySet()){
            double[] b = c.get(key);
            similarities.put(key,similarity(a,b));
        }
        return similarities;
    }
}
