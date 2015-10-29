package es.upm.oeg.lab.analyzers;

import es.upm.oeg.epnoi.matching.metrics.topics.search.LDASolution;
import es.upm.oeg.lab.harvester.Scope;
import es.upm.oeg.lab.modelers.TopicModeler;
import es.upm.oeg.lab.utils.ResultHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbadenes on 29/10/15.
 */
public class TopicsAnalyzer {

    private static final Logger logger = LoggerFactory.getLogger(TopicsAnalyzer.class);

    public static void analyze(Scope scope){

        logger.info("Analyzing corpus based on " + scope.name().toString() + " ..");

        TopicModeler modeler = new TopicModeler("acm-siggraph-2006-2014-upf-ros/*."+scope.id);

        Integer maxEval = 100; // 100
        Integer maxIt   = 200; // 200

        ResultHelper helper = new ResultHelper("topics.settings."+scope.id);
        helper.add(Arrays.asList(new String[]{
                "maxEval",
                "maxIt",
                "alpha",
                "beta",
                "loglikelihood",
                "logprior",
                "topics"}));

        IntStream.
                range(0, 100).
                mapToObj(i -> modeler.learn(maxEval, maxIt)).
                forEach(s -> helper.add(Arrays.asList(new String[]{
                        String.valueOf(maxEval),
                        String.valueOf(maxIt),
                        String.valueOf(s.getAlpha()),
                        String.valueOf(s.getBeta()),
                        String.valueOf(s.getLoglikelihood()),
                        String.valueOf(s.getLogPrior()),
                        String.valueOf(s.getTopics()),
                })));

        helper.finish();
    }


    public static void main(String[] args){

//        TopicsAnalyzer.analyze(Scope.ABSTRACT);

        // All the scopes
        Arrays.asList(Scope.values()).stream().forEach(scope -> TopicsAnalyzer.analyze(scope));



    }

}
