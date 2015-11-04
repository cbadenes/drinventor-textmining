package es.upm.oeg.lab.builders;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by cbadenes on 03/11/15.
 */
public class RankDistanceBuilderTest {

    Logger logger = LoggerFactory.getLogger(RankDistanceBuilderTest.class);

    @Test
    public void identical(){

        logger.info("######  Test: Identical Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{3,4,5};
        calculateSimilarity(p,q);

    }

    @Test
    public void inverse(){

        logger.info("######  Test: Inverse Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{5,4,3};
        calculateSimilarity(p,q);

    }

    @Test
    public void completelyDifferent(){

        logger.info("######  Test: Different Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{1,2,6};
        calculateSimilarity(p,q);

    }

    @Test
    public void partialDifferentOneSimilar(){

        logger.info("######  Test: One Similar Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{3,2,6};
        calculateSimilarity(p,q);

    }

    @Test
    public void partialDifferentOneSimilar2(){

        logger.info("######  Test: One Similar (2) Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{1,4,6};
        calculateSimilarity(p,q);

    }


    @Test
    public void partialDifferentOneSimilar3(){

        logger.info("######  Test: One Similar (3) Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{1,2,5};
        calculateSimilarity(p,q);

    }

    @Test
    public void partialDifferentTwoSimilar(){

        logger.info("######  Test: Two Similar Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{3,4,6};
        calculateSimilarity(p,q);

    }

    @Test
    public void partialDifferentTwoSimilar2(){

        logger.info("######  Test: Two Similar (2) Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{1,4,5};
        calculateSimilarity(p,q);

    }

    @Test
    public void partialDifferentTwoSimilar3(){

        logger.info("######  Test: Two Similar (3) Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{3,2,5};
        calculateSimilarity(p,q);

    }

    @Test
    public void differentOrder(){

        logger.info("######  Test: Different Order Lists");
        int[] p = new int[]{3,4,5};
        int[] q = new int[]{5,3,4};
        calculateSimilarity(p,q);

    }

    private void calculateSimilarity(int[]p, int[]q){
        RankDistanceBuilder.kendallDistance(p, q);
        RankDistanceBuilder.spearmanDistance(p, q);
        RankDistanceBuilder.distancesDistance(p, q);
        RankDistanceBuilder.distances2Distance(p, q);
        RankDistanceBuilder.editDistance(p, q);
        RankDistanceBuilder.vertexRanking(p, q);
    }

}
