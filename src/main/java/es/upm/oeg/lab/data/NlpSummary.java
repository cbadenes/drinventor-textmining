package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class NlpSummary implements Serializable{

    String id;

    Long numSentences;

    Long numDistLemmas;
    Long numTotalLemmas;

    Long numDistWords;
    Long numTotalWords;

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
}
