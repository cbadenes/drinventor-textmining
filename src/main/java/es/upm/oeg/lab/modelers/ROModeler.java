package es.upm.oeg.lab.modelers;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.epnoi.ressist.parser.CRParser;
import es.upm.oeg.epnoi.ressist.parser.ROPair;
import es.upm.oeg.epnoi.ressist.parser.ROParser;
import es.upm.oeg.epnoi.ressist.parser.RRParser;
import es.upm.oeg.lab.helpers.SparkHelper;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cbadenes on 30/10/15.
 */
public class ROModeler {

    private static final Logger logger        = LoggerFactory.getLogger(ROModeler.class);

    protected static final ROParser roParser  = new ROParser();

    protected static final ROPair roPair      = new ROPair();

    protected static final RRParser rrParser  = new RRParser();

    protected static final CRParser crParser  = new CRParser();

    protected static final JavaSparkContext sc = SparkHelper.sc;

    public ROModeler() {
    }

    public JavaRDD<ResearchObject> loadROs(String path){
        // Load directory as RDD of file (name,content)
        JavaPairRDD<String, String> input = sc.wholeTextFiles(path);

        // Convert files to Research Objects
        JavaRDD<ResearchObject> researchObjects = input.flatMap(roParser);
        logger.info(researchObjects.count() + " research objects were loaded!");
        return researchObjects;
    }
}
