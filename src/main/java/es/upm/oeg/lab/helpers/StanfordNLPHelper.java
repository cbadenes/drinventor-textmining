package es.upm.oeg.lab.helpers;

import edu.stanford.nlp.ling.CoreAnnotations.*;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.Pair;
import es.upm.oeg.lab.data.Text;
import es.upm.oeg.lab.data.Token;
import intoxicant.analytics.coreNlp.StopwordAnnotator;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by cbadenes on 27/10/15.
 */
public class StanfordNLPHelper {

    //adding extra terms to standard lucene list
    private static final String customStopWordList = "" +
            "a,also,an,and,any,are,as,at," +
            "be,become,both,bring,but,by," +
            "can,come," +
            "do," +
            "e.g.,example,extend,enough,enhance," +
            "for,from," +
            "give,get,greatly," +
            "have,highly,high," +
            "if,i.e.,in,into,is,it,its," +
            "keyword,keywords," +
            "more,most," +
            "no,not," +
            "of,on,or,only,onto" +
            "paper,provide," +
            "same,show,such," +
            "take,that,than,the,their,then,there,thereby,these,they,this,to,tool," +
            "use,up,"+
            "was,we,where,which,widely,will,with,yet";

    protected StanfordCoreNLP pipeline;

    public StanfordNLPHelper() {

        Properties props;
        props = new Properties();
        props.put("annotators", "tokenize, cleanxml, ssplit, pos, lemma, stopword"); //"tokenize, ssplit, pos, lemma, ner, parse, dcoref"

        // Custom sentence split
        props.setProperty("ssplit.boundaryTokenRegex", "[.]|[!?]+|[。]|[！？]+");

        // Custom tokenize
        props.setProperty("tokenize.options","untokenizable=allDelete,normalizeOtherBrackets=false,normalizeParentheses=false");

        // Custom stopwords
        props.setProperty("customAnnotatorClass.stopword", "intoxicant.analytics.coreNlp.StopwordAnnotator");
//            props.setProperty(StopwordAnnotator.CHECK_LEMMA, "true");
        props.setProperty(StopwordAnnotator.STOPWORDS_LIST, customStopWordList);

        this.pipeline = new StanfordCoreNLP(props);
    }

    public List<String> lemmatize(String documentText)
    {
        // Replace question marks
        String text = documentText.replace("?","?.");

        List<String> tokens = new LinkedList<String>();

        // Create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        this.pipeline.annotate(document);

        // Iterate over all of the sentences found
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);

        for(CoreMap sentence: sentences) {
            // Iterate over all tokens in a sentence
            for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(TextAnnotation.class);
                // this is the POS tag of the token
                String pos = token.get(PartOfSpeechAnnotation.class);
                // Retrieve and add the lemma for each word into the
                // list of lemmas
                String lemma = token.get(LemmaAnnotation.class);

                Pair<Boolean, Boolean> stopword = token.get(StopwordAnnotator.class);

                if (!stopword.first
                        && lemma.length()>2
                        && lemma.matches(".*[a-zA-Z]+.*")) {
                    tokens.add(lemma.toLowerCase());
                }
            }
        }
        return tokens;
    }

    public Text parse(String documentText)
    {
        // Replace question marks
        String text = documentText.replace("?","?.");

        // Create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        this.pipeline.annotate(document);

        Text info = new Text();
        info.setContent(documentText);

        // Iterate over all of the sentences found
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);
        info.setNumSentences(sentences.size());

        for(CoreMap sentence: sentences) {
            // Iterate over all tokens in a sentence
            for (CoreLabel coreLabel: sentence.get(TokensAnnotation.class)) {
                Token token = new Token();
                token.setPos(coreLabel.get(PartOfSpeechAnnotation.class));
                token.setLemma(coreLabel.get(LemmaAnnotation.class));
                token.setWord(coreLabel.get(TextAnnotation.class));
                token.setStopWord(coreLabel.get(StopwordAnnotator.class).first);
                info.add(token);
            }
        }
        return info;
    }


}
