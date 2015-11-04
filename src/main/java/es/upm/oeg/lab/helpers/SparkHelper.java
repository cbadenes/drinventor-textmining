package es.upm.oeg.lab.helpers;

import com.google.common.base.Strings;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by cbadenes on 03/11/15.
 */
public class SparkHelper {

    public static final SparkConf conf;

    public static final JavaSparkContext sc;

    static {

        String threads = System.getenv("DRI.SPARK.THREADS");
        if (Strings.isNullOrEmpty(threads)) threads = "2";

        String mem = System.getenv("DRI.SPARK.MEM");
        if (Strings.isNullOrEmpty(mem)) mem = "3g";


        // Initialize Spark Context
        conf = new SparkConf().
                setMaster("local["+threads+"]").
                setAppName("DrInventor").
                set("spark.executor.memory", mem).
                set("spark.driver.maxResultSize","0");
        sc = new JavaSparkContext(conf);
    }
}
