package es.upm.oeg.lab.utils;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by cbadenes on 27/10/15.
 */
public class StanfordNLPHelper {

    protected StanfordCoreNLP pipeline;

        public StanfordNLPHelper() {
            // Create StanfordCoreNLP object properties, with POS tagging
            // (required for lemmatization), and lemmatization
            Properties props;
            props = new Properties();
            props.put("annotators", "tokenize, ssplit, pos"); //"tokenize, ssplit, pos, lemma, ner, parse, dcoref"
//            props.setProperty("annotators", "tokenize, ssplit, pos, lemma");

            /*
             * This is a pipeline that takes in a string and returns various analyzed linguistic forms.
             * The String is tokenized via a tokenizer (such as PTBTokenizerAnnotator),
             * and then other sequence model style annotation can be used to add things like lemmas,
             * POS tags, and named entities. These are returned as a list of CoreLabels.
             * Other analysis components build and store parse trees, dependency graphs, etc.
             *
             * This class is designed to apply multiple Annotators to an Annotation.
             * The idea is that you first build up the pipeline by adding Annotators,
             * and then you take the objects you wish to annotate and pass them in and
             * get in return a fully annotated object.
             *
             *  StanfordCoreNLP loads a lot of models, so you probably
             *  only want to do this once per execution
             */
            this.pipeline = new StanfordCoreNLP(props);
        }

        public List<String> lemmatize(String documentText)
        {
            List<String> lemmas = new LinkedList<String>();

            // Create an empty Annotation just with the given text
            Annotation document = new Annotation(documentText);

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
                    lemmas.add(token.get(LemmaAnnotation.class));
                }
            }
            return lemmas;
        }
}