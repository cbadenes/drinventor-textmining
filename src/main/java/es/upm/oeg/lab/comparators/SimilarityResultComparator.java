package es.upm.oeg.lab.comparators;

import es.upm.oeg.lab.data.SimilarityResult;

/**
 * Created by cbadenes on 08/11/15.
 */
public class SimilarityResultComparator {

    public static SimilarityResult mostSimilar(SimilarityResult a, SimilarityResult b){
        return (a.getSimilarity() > b.getSimilarity())? a : b;
    }
}
