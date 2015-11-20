package es.upm.oeg.lab.helpers;

import es.cbadenes.lab.test.IntegrationTest;
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
                "with s, and a scene -with objects shown in grey- we can compute visibility -rgb- by considering all rays from " +
                "the view cell to a plane behind the scene, parameterized with realism?animation";
        String outputText   = this.stanfordHelper.lemmatize(text).stream().collect(Collectors.joining(" "));
        String targetText   = "figure illustrate concept ray space 2d give view cell show edge parameterize scene object show grey we can compute visibility rgb consider all ray from view cell plane behind scene parameterize realism animation";

        System.out.println("Input TEXT:\t" + text);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }

    @Test
    public void sentences(){

        String text = "Figure 2 illustrates the concept of realism?animation ray space in 2D.";
        String outputText   = this.stanfordHelper.lemmatize(text).stream().collect(Collectors.joining(" "));
        String targetText   = "figure illustrate concept realism animation ray space 2d";

        System.out.println("Input TEXT:\t" + text);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }

    @Test
    public void parser(){

        String text = "I.3.7 [Computer Graphics]: 3.7 Three-Dimensional Graphics and Realism—Animation;";
        String outputText   = this.stanfordHelper.lemmatize(text).stream().collect(Collectors.joining(" "));
        String targetText   = "i. computer graphics three-dimensional graphics realism animation";

        System.out.println("Input TEXT:\t" + text);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }

    @Test
    public void parserParenthesis(){
        String text = "Median filtering is a cornerstone of modern image processing and is used extensively in smoothing and de-noising applications. The fastest commercial implementations (e.g. in Adobe ? Photoshop ? CS2) exhibit O(r) runtime in the radius of the filter, which limits their usefulness in realtime or resolution-independent contexts. We introduce a CPU-based, vectorizable O(log r) algorithm for median filtering, to our knowledge the most efficient yet developed. Our algorithm extends to images of any bit-depth, and can also be adapted to perform bilateral filtering. On 8-bit data our median filter outperforms Photoshop?s implementation by up to a factor of fifty. CR Categories: F.2.2 [Analysis of Algorithms and Problem Complexity]: Nonnumerical Algorithms and Problems ? Sorting and Searching; I.4.3 [Image Processing and Computer Vision]: Enhancement ? Filtering ; D.2.8 [Software Engineering]: Metrics ? Complexity Measures; E.1 [Data Structures]: Arrays Keywords: median filtering, bilateral filtering, rank-order filtering, sorting, image processing, algorithms, histograms, data structures, complexity, SIMD, vector processing";
        String outputText   = this.stanfordHelper.lemmatize(text).stream().collect(Collectors.joining(" "));
        String targetText   = "median filter cornerstone modern image processing use extensively smoothing de-noising application fastest commercial implementation adobe photoshop cs2 exhibit runtime radius filter which limit usefulness realtime resolution-independent context introduce cpu-based vectorizable log algorithm median filter knowledge most efficient yet develop algorithm extend image any bit-depth can also adapt perform bilateral filter 8-bit datum median filter outperform photoshop implementation factor fifty category analysis algorithm problem complexity nonnumerical algorithm problem sort searching image processing computer vision enhancement filter software engineering metric complexity measure data structure array keyword median filter bilateral filter rank-order filter sort image processing algorithm histogram datum structure complexity simd vector processing";

        System.out.println("Input TEXT:\t" + text);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }


}
