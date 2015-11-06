package es.upm.oeg.lab.helpers;

import es.upm.oeg.lab.builders.SummaryBuilder;
import es.upm.oeg.lab.data.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cbadenes on 05/11/15.
 */
public class StanfordNLPHelperTest {

    private StanfordNLPHelper helper;

    @Before
    public void setup(){
        this.helper = new StanfordNLPHelper();
    }

    @Test
    public void distinctTokens(){

        Item item = new Item();
        item.setDate("2015");
        item.setAuthors(new ArrayList<>());
        item.setRefPaper(new Paper());
        item.setTitle("sample");

        Text text = helper.parse("cars and car");

        Section section = new Section(text,Section.Type.ABSTRACT);
        item.add(section);


        text.getTokens().stream().map(t -> t.getLemma()).distinct().forEach(l -> System.out.printf(l));

        Summary summary = SummaryBuilder.newInstance(item);

        NlpSummary nlpSummary = summary.getSections().get(0);
        Assert.assertEquals("Tokens", new Long(3),nlpSummary.getNumTokens());
        Assert.assertEquals("Words", new Long(3),nlpSummary.getNumWords());
        Assert.assertEquals("Lemmas", new Long(2), nlpSummary.getNumLemmas());
    }

}
