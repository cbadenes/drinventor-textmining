package es.upm.oeg.lab;

import es.cbadenes.lab.test.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by cbadenes on 18/11/15.
 */
@Category(IntegrationTest.class)
public class ParseDocTest {


    @Test
    public void simulate(){

        String[] args = new String[8];
        args[0] = "sample-db";
        args[1] = "corpus-intech/papers/biomass-0.pdf";
        args[2] = "biomass-0.pdf";
        args[3] = "Remote Characterization of Biomass Measurements: Case Study of Mangrove Forests";
        args[4] = "biomass";

        ParseDoc.main(args);
    }

}
