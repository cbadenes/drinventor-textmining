package es.upm.oeg.lab.data;

import es.upm.oeg.lab.builders.SummaryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by cbadenes on 05/11/15.
 */
public class SummaryBuilderTest {

    @Test
    public void testDistintc(){

        Item item = new Item();
        item.setDate("2015");
        item.setAuthors(new ArrayList<>());
        item.setRefPaper(new Paper());
        item.setTitle("sample");

        Text text = new Text();
        text.setNumSentences(1);
        text.add(newToken("lemma1","word1"));
        text.add(newToken("lemma1","word2"));
        Part part = new Part(text, Part.Type.ABSTRACT);
        item.setPart(part);


        Summary summary = SummaryBuilder.newInstance(item);

        NlpSummary nlpSummary = summary.getSections().get(0);
        Assert.assertEquals("Tokens", new Long(2),nlpSummary.getNumTokens());
        Assert.assertEquals("Words", new Long(2),nlpSummary.getNumWords());
        Assert.assertEquals("Lemmas", new Long(1), nlpSummary.getNumLemmas());

    }

    private Token newToken(String lema,String word){
        Token token = new Token();
        token.setLemma(lema);
        token.setWord(word);
        token.setPos("NN");
        token.setStopWord(false);
        return token;
    }


}
