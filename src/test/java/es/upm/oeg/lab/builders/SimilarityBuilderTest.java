package es.upm.oeg.lab.builders;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by cbadenes on 03/11/15.
 */
public class SimilarityBuilderTest {


    @Test
    public void getSimilarity(){

        double[] a = new double[]{2.0,1.0,3.2};
        double[] b = new double[]{2.0,1.0,3.2};

        double result = SimilarityBuilder.similarity(a, b);

        System.out.println("Similarity between: " + Arrays.toString(a) + " and " + Arrays.toString(b) + " is: " + result);

    }

}
