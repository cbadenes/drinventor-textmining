package es.upm.oeg.lab.function;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import org.apache.spark.api.java.function.Function;

import java.util.List;

/**
 * Created by cbadenes on 30/10/15.
 */
public class ROBagOfWords implements Function<ResearchObject, List<String>> {

    public ROBagOfWords() {
    }

    public List<String> call(ResearchObject ro) throws Exception {
        return ro.getBagOfWords();
    }
}

