package es.upm.oeg.lab.function;

import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

/**
 * Created by cbadenes on 08/11/15.
 */
public class TuplePairFunction implements PairFunction<Tuple2<String, Integer>, String, Integer> {


    @Override
    public Tuple2<String, Integer> call(Tuple2<String,Integer> t) throws Exception {
        return new Tuple2<String, Integer>(t._1(),t._2());
    }
}
