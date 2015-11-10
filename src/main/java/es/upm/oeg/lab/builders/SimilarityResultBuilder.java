package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.matching.metrics.similarity.JensenShannonSimilarity;
import es.upm.oeg.lab.data.ModeledItem;
import es.upm.oeg.lab.data.SimilarityResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cbadenes on 03/11/15.
 */
public class SimilarityResultBuilder {

    private static final Logger logger = LoggerFactory.getLogger(SimilarityResultBuilder.class);

    public static SimilarityResult build(ModeledItem a, ModeledItem b){
        SimilarityResult result = new SimilarityResult();
        result.setItem1(a);
        result.setItem2(b);

        double similarity = 0.0;
        if (a.getTopicDistribution().length == b.getTopicDistribution().length){
            similarity = JensenShannonSimilarity.apply(a.getTopicDistribution(), b.getTopicDistribution());
        }
        result.setSimilarity(similarity);
        return result;
    }
}
