package es.upm.oeg.lab.utils;

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
public class NLPTest {

    private static final String inputText    = "Some houses have many mice.  Our house only has one mouse.";
    private static final String targetText   = "some house has many mouse .  our house only has one mouse .";


    private OpenNLPHelper openHelper;
    private StanfordNLPHelper stanfordHelper;


    public void setup() throws IOException {
        this.openHelper = new OpenNLPHelper();
        this.stanfordHelper = new StanfordNLPHelper();
    }

    public void shutdown() throws IOException {
        this.openHelper.destroy();
    }

    public void lemmasInOpenNLP(){

        String outputText   = this.openHelper.parse(inputText).stream().collect(Collectors.joining(" "));

        System.out.println("Input TEXT:\t" + inputText);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }

    public void lemmasInStanfordNLP(){

        String outputText   = this.stanfordHelper.lemmatize(inputText).stream().collect(Collectors.joining(" "));

        System.out.println("Input TEXT:\t" + inputText);
        System.out.println("Target TEXT:\t" + targetText);
        System.out.println("Output TEXT:\t" + outputText);

        Assert.assertEquals(targetText,outputText);
    }

}
