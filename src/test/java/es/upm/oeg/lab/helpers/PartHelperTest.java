package es.upm.oeg.lab.helpers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cbadenes on 27/10/15.
 */
public class PartHelperTest {

    private List<String> introductionSections = Arrays.asList(new String[]{
            "1 Introduction",
            "introduction",
            "background",
            "related work",
            "2 Previous Work",
            "2 Related work",
            "2 Background"
    });

    private List<String> conclusionSections = Arrays.asList(new String[]{
            "6 Conclusion",
            "6 Conclusion & Future Work",
            "6 Limitations and future work",
            "7 Conclusion",
            "5 Results",
            "5 Results and discussion"
    });

    @Test
    public void testIntroduction(){

        List<String> expressions = Arrays.asList(new String[]{"introduction", "related work", "previous work", "background"});

        introductionSections.stream().forEach(s -> Assert.assertTrue("Checking if true  '" + s +"'",SectionHelper.match(s, expressions)));
        conclusionSections.stream().forEach(s -> Assert.assertFalse("Checking if false  '" + s +"'", SectionHelper.match(s, expressions)));
    }

    @Test
    public void testConclusion(){
        List<String> expressions = Arrays.asList(new String[]{"results", "conclusion", "future work"});

        introductionSections.stream().forEach(s -> Assert.assertFalse("Checking if false '" + s +"'",SectionHelper.match(s, expressions)));
        conclusionSections.stream().forEach(s -> Assert.assertTrue("Checking if true  '" + s +"'",SectionHelper.match(s, expressions)));
    }


}
