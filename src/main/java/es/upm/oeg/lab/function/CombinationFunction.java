package es.upm.oeg.lab.function;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

/**
 * Created by cbadenes on 11/11/15.
 */
public class CombinationFunction {

    public static <T> JavaPairRDD<T, T> combine(JavaRDD<T> list){
        return list.cartesian(list).filter(t -> t._1().hashCode() < t._2().hashCode());
    }
}
