package es.upm.oeg.lab;

import es.cbadenes.lab.test.IntegrationTest;
import es.upm.oeg.lab.data.Part;
import es.upm.oeg.lab.function.CombinationFunction;
import es.upm.oeg.lab.helpers.SparkHelper;
import org.apache.spark.api.java.JavaRDD;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import scala.Tuple2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cbadenes on 02/11/15.
 */
@Category(IntegrationTest.class)
public class AnalyzerTest {

    private Analyzer analyzer;

    @Before
    public void setup(){
        this.analyzer = new Analyzer();
    }

    @Test
    public void testCorpus() throws IOException {
        analyzer.analyze(
                "src/test/resources/acm-siggraph-2006-2014-upf",
                "src/main/resources/siggraphpaperMetaFilenames.json",
                10,
                100,
                10
        );
    }


    @Test
    public void cartesian(){

        List<String> l1 = Arrays.asList(new String[]{"one","two","three"});

        JavaRDD<String> l1RDD = SparkHelper.sc.parallelize(l1);

        List<Tuple2<String, String>> l1l1 = l1RDD.cartesian(l1RDD).filter(i -> i._1().hashCode() < i._2().hashCode()).collect();

        CombinationFunction.combine(l1RDD).collect().stream().forEach(t -> System.out.println(t._1() + "-" + t._2()));
    }


    @Test
    public void combinedSection(){

        for (Part.Type section: Part.Type.values()){
            System.out.println("Section: " + section);
            String[] sections = section.name().split("_");
            Arrays.stream(sections).forEach(s -> System.out.println(s));
        }
    }
}
