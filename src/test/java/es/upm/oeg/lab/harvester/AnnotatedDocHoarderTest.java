package es.upm.oeg.lab.harvester;

import es.cbadenes.lab.test.IntegrationTest;
import es.upm.oeg.lab.hoarder.AnnotatedDocHoarder;
import es.upm.oeg.lab.upf.Criteria;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by cbadenes on 26/10/15.
 */
@Category(IntegrationTest.class)
public class AnnotatedDocHoarderTest {

    private AnnotatedDocHoarder handler;

    @Before
    public void setup(){
        this.handler = new AnnotatedDocHoarder("src/test/resources/acm-siggraph-2006-2014-upf");
    }

    @Test
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

