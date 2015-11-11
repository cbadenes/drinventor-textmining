package es.upm.oeg.lab.data;

import es.upm.oeg.lab.log.DIMarkers;
import lombok.Data;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.stat.MultivariateStatisticalSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class NlpSummary implements Serializable{

    private static final Logger logger = LoggerFactory.getLogger(NlpSummary.class);

    private static final String[] labels = new String[]{
            "numSentences",
            "numTokens",
            "numWords",
            "numLemmas",
            "numJJ",
            "numNN",
            "numNNP",
            "numNNPS",
            "numRB",
            "numRP",
            "numIN",
            "numVB",
            "numVBD",
            "numVBN",
            "numVBP"

    };

    String name;

    String label;

    Long numSentences;

    Long numTokens;
    Long numWords;
    Long numLemmas;

    // Part-of-Speech
    Long numJJ;
    Long numNN;
    Long numNNP;
    Long numNNPS;
    Long numRB;
    Long numRP;
    Long numIN;
    Long numVB;
    Long numVBD;
    Long numVBN;
    Long numVBP;

    public Vector toVector(){
        return Vectors.dense(
                numSentences,
                numTokens,
                numWords,
                numLemmas,
                numJJ,
                numNN,
                numNNP,
                numNNPS,
                numRB,
                numRP,
                numIN,
                numVB,
                numVBD,
                numVBN,
                numVBP);
    }

    public static void log(MultivariateStatisticalSummary statisticalSummary, Part.Type section){
        logger.info(DIMarkers.stats,"Count for '"+section+"': " + statisticalSummary.count());

        logVector(section,"min",labels,statisticalSummary.min().toArray());
        logVector(section,"max",labels,statisticalSummary.max().toArray());
        logVector(section,"numNonZeros",labels,statisticalSummary.numNonzeros().toArray());
        logVector(section, "mean", labels, statisticalSummary.mean().toArray());
        logVector(section,"variance",labels,statisticalSummary.variance().toArray());
        logVector(section, "normL1", labels, statisticalSummary.normL1().toArray());
        logVector(section,"normL2",labels,statisticalSummary.normL2().toArray());
    }

    private static void logVector(Part.Type section, String prefix, String[] labels, double[] values){

        for (int i=0;i < labels.length ; i++){
            logger.info(DIMarkers.stats,prefix + " " + labels[i] +" for '"+section+"': " + values[i]);
        }
    }
}
