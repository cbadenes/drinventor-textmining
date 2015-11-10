package es.upm.oeg.lab.data;

import org.junit.Test;

/**
 * Created by cbadenes on 05/11/15.
 */
public class SummaryTest {

    @Test
    public void statistics(){

        Double truePositives=0.0;
        Double falsePositives=1.0;
        Double falseNegatives=0.0;

        Double precision    = truePositives / (truePositives + falsePositives);
        Double recall       = truePositives / (truePositives + falseNegatives);
        Double fmeasure     = 2 * (precision*recall)/(precision+recall);

        if (recall.isNaN()) recall = 0.0;

        System.out.println("Precision="+ precision);
        System.out.println("Recall="+ recall);
        System.out.println("FMeasure="+ fmeasure);

    }
}
