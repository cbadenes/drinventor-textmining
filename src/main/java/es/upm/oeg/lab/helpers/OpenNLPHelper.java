package es.upm.oeg.lab.helpers;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by cbadenes on 26/10/15.
 */
public class OpenNLPHelper {

    private final InputStream sentenceDictionary;
    private final InputStream tokenDictionary;
    private final InputStream posTagDictionary;
    private final InputStream namesDictionary;
    private final InputStream chunkerDictionary;
    private final InputStream lemmaDictionary;
    private final InputStream parserDictionary;

    private final SentenceDetectorME sentenceDetector;
    private final TokenizerME tokenizer;
    private final NameFinderME nameFinder;
    private final POSTaggerME tagger;
    private final ChunkerME chunker;
    private final Parser parser;

    public OpenNLPHelper() throws IOException {

        // Dictionaries
//        this.sentenceDictionary = new FileInputStream("classpath:models/en-sent.bin");
        this.sentenceDictionary = new FileInputStream("src/main/opennlp-models/en-sent.bin");
        this.tokenDictionary    = new FileInputStream("src/main/opennlp-models/en-token.bin");
        this.namesDictionary    = new FileInputStream("src/main/opennlp-models/en-ner-person.bin");
        this.posTagDictionary   = new FileInputStream("src/main/opennlp-models/en-pos-maxent.bin");
        this.lemmaDictionary    = new FileInputStream("src/main/opennlp-models/en-pos-perceptron.bin");
        this.chunkerDictionary  = new FileInputStream("src/main/opennlp-models/en-chunker.bin");
        this.parserDictionary   = new FileInputStream("src/main/opennlp-models/en-parser-chunking.bin");

        // Analyzers
        this.sentenceDetector   = new SentenceDetectorME(new SentenceModel(sentenceDictionary));
        this.tokenizer          = new TokenizerME(new TokenizerModel(tokenDictionary));
        this.nameFinder         = new NameFinderME(new TokenNameFinderModel(namesDictionary));
        this.tagger             = new POSTaggerME(new POSModel(lemmaDictionary));
        this.chunker            = new ChunkerME(new ChunkerModel(chunkerDictionary));
        this.parser             = ParserFactory.create(new ParserModel(parserDictionary));


    }

    public void destroy() throws IOException {
        this.sentenceDictionary.close();
        this.tokenDictionary.close();
        this.namesDictionary.close();
        this.posTagDictionary.close();
        this.chunkerDictionary.close();
    }


    public List<String> sentences(String paragraph){
        return Arrays.asList(sentenceDetector.sentDetect(paragraph));
    }

    public String[] tokens(String sentence){
        return this.tokenizer.tokenize(sentence);
    }

    public List<String> names(String[] tokens){
        return Arrays.asList(this.nameFinder.find(tokens)).stream().map(s -> s.toString()).collect(Collectors.toList());
    }

    public String[] tags(String[] tokenizedSentence){
        return tagger.tag(tokenizedSentence);
    }

    public Parse parseLine(String sentence){
        return ParserTool.parseLine(sentence, parser, 1)[0];
    }

}
