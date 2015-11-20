package es.upm.oeg.lab.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cbadenes on 18/11/15.
 */
public class SectionTest {


    @Test
    public void validateType(){

        Assert.assertTrue(Section.Type.contains("full"));

    }
}
