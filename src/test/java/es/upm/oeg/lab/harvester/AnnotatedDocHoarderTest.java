package es.upm.oeg.lab.harvester;

import es.upm.oeg.lab.hoarder.AnnotatedDocHoarder;
import es.upm.oeg.lab.upf.Criteria;

/**
 * Created by cbadenes on 26/10/15.
 */
public class AnnotatedDocHoarderTest {

    private AnnotatedDocHoarder handler;

    public void setup(){
        this.handler = new AnnotatedDocHoarder("src/test/resources/acm-siggraph-2006-2014-upf");
    }

    public void splitByAbstracts(){

        String to   = "target/output";

        Criteria by = Criteria.builder().
                fullText(true).
                abstracts(true).
                centroidSummary(true).
                titleSummary(true).
                outcome(true).
                futureWork(true).
                approach(true).
                background(true).
                challenge(true).
                build();

        handler.split(to,by,true);
    }

}

