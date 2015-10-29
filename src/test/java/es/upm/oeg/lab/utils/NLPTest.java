package es.upm.oeg.lab.utils;

import es.cbadenes.lab.test.IntegrationTest;
import is2.lemmatizer.Lemmatizer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 26/10/15.
 */
@Category(IntegrationTest.class)
public class NLPTest {

    private static final String inputText    = "Some houses have many mice.  Our house only has one mouse.";
    private static final String targetText   = "some house have many mouse . we house only have one mouse .";


    private OpenNLPHelper openHelper;
    private StanfordNLPHelper stanfordHelper;


    @Before
    public void setup() throws IOException {
        this.openHelper     = new OpenNLPHelper();
        this.stanfordHelper = new StanfordNLPHelper();
    }

    @After
    public void shutdown() throws IOException {
        this.openHelper.destroy();
    }

    @Test
    public void lemmasInOpenNLP(){

        String outputText   = this.openHelper.parse(inputText).stream().collect(Collectors.joining(" "));

        System.out.println("Input TEXT:\t" + inputText);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }

    /**
     * +/Users/cbadenes/Projects/drinventor-textmining/alternateLocation/seg-1.0.jar
     /Users/cbadenes/Projects/drinventor-textmining/alternateLocation/seg-1.0.jar/edu/stanford/nlp/process/WordToSentenceProcessor.class
     +/Users/cbadenes/Projects/drinventor-textmining/alternateLocation/stanford-corenlp-3.5.0.jar
     /Users/cbadenes/Projects/drinventor-textmining/alternateLocation/stanford-corenlp-3.5.0.jar/edu/stanford/nlp/process/WordToSentenceProcessor.class
     /Users/cbadenes/Projects/drinventor-textmining/alternateLocation/stanford-corenlp-3.5.0.jar/edu/stanford/nlp/process/WordToSentenceProcessor$NewlineIsSentenceBreak.class
     */
    @Test
    public void lemmasInStanfordNLP(){

        String outputText   = this.stanfordHelper.lemmatize(inputText).stream().collect(Collectors.joining(" "));

        System.out.println("Input TEXT:\t" + inputText);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }

    @Test
    public void stopWords(){

        String text = "Figure 2 illustrates the concept of ray space in 2D. Given a view cell, shown as edge parameterized " +
                "with s, and a scene with objects shown in grey, we can compute visibility by considering all rays from " +
                "the view cell to a plane behind the scene, parameterized with t.";
        String outputText   = this.stanfordHelper.lemmatize(text).stream().collect(Collectors.joining(" "));
        String targetText   = "figure illustrate concept ray space 2d give view cell show edge parameterize scene object show grey we can compute visibility consider all ray from view cell plane behind scene parameterize t.";

        System.out.println("Input TEXT:\t" + text);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }


}
