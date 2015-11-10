package es.upm.oeg.lab.function;

import es.upm.oeg.lab.builders.SimilarityResultBuilder;
import es.upm.oeg.lab.data.ModeledItem;
import es.upm.oeg.lab.data.SimilarityResult;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

/**
 * Created by cbadenes on 08/11/15.
 */
public class ModelSimilarityPairFunction implements PairFunction<Tuple2<ModeledItem, ModeledItem>, ModeledItem, SimilarityResult> {


    @Override
    public Tuple2<ModeledItem, SimilarityResult> call(Tuple2<ModeledItem, ModeledItem> t) throws Exception {
        return new Tuple2<ModeledItem, SimilarityResult>(t._1(), SimilarityResultBuilder.build(t._1(), t._2()));
    }
}
