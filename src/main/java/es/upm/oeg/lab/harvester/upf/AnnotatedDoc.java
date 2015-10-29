package es.upm.oeg.lab.harvester.upf;

import edu.upf.taln.dri.lib.exception.DRIexception;
import edu.upf.taln.dri.lib.exception.InternalProcessingException;
import edu.upf.taln.dri.lib.model.Document;
import edu.upf.taln.dri.lib.model.ext.*;
import es.upm.oeg.lab.utils.SectionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbadenes on 26/10/15.
 */
public class AnnotatedDoc {

    private static final Logger logger = LoggerFactory.getLogger(AnnotatedDoc.class);

    private final List<Sentence> sentences;

    private final Path path;
    private final SectionHelper sectionHelper;

    private Document document;

    public AnnotatedDoc(Path path){
        try {
            this.path           = path;
            this.document       = DocumentFactory.parse(path);
            this.sentences      = this.document.extractSentences(SentenceSelectorENUM.ALL); // Maybe ALL_EXCEPT_ABSTRACT?
            this.sectionHelper  = new SectionHelper(document.extractSections(false));
        } catch (DRIexception e) {
            logger.error("Error parsing annotated document from: " + path);
           throw new RuntimeException(e);
        }
    }

    public Path getPath(){
        return this.path;
    }

    public Document getDocument(){ return this.document;}

    public String getFileName(){
        try{
            return document.getName();
        } catch (InternalProcessingException e) {
            logger.error("Error getting name from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getFullText()  {
        try {
            logger.debug("reading full text from: " + document.getName());
            return this.document.getRawText();
        } catch (InternalProcessingException e) {
            logger.error("Error getting full text from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getTitle(){
        try{
            return this.document.extractHeader().getTitle();
        } catch (InternalProcessingException e) {
            logger.error("Error getting title from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getDoi(){
        try{
            return this.document.extractHeader().getDoi();
        } catch (InternalProcessingException e) {
            logger.error("Error getting doi from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getYear(){
        try{
            return this.document.extractHeader().getYear();
        } catch (InternalProcessingException e) {
            logger.error("Error getting year from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public List<Author> getAuthors(){
        try{
            return this.document.extractHeader().getAuthorList();
        } catch (InternalProcessingException e) {
            logger.error("Error getting year from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getAbstract() {
        try {
            logger.debug("reading abstract from: " + document.getName());
            return join(this.document.extractSentences(SentenceSelectorENUM.ONLY_ABSTRACT).stream());
        } catch (InternalProcessingException e) {
            logger.error("Error getting abstract from: " + document,e);
            throw new RuntimeException(e);
        }
    }

    public String getSummaryByCentroid(int numLines){
        try {
            logger.debug("reading summary [" + numLines + "] by centroid from: " + document.getName());
            return join(this.document.extractSummary(numLines, SummaryTypeENUM.CENTROID_SECT).stream());
        } catch (InternalProcessingException e) {
            logger.error("Error getting summary by centroid from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getSummaryByTitle(int numLines){
        try {
            logger.debug("reading summary [" + numLines + "] by centroid from: " + document.getName());
            return join(this.document.extractSummary(numLines, SummaryTypeENUM.TITILE_SIM).stream());
        } catch (InternalProcessingException e) {
            logger.error("Error getting summary by centroid from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getOutcome(){
        try {
            logger.debug("reading outcome from: " + document.getName());
            return join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_Outcome)));
        } catch (InternalProcessingException e) {
            logger.error("Error getting outcome from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getFutureWork(){
        try {
            logger.debug("reading future work from: " + document.getName());
            return join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_FutureWork)));
        } catch (InternalProcessingException e) {
            logger.error("Error getting future work from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getApproach(){
        try {
            logger.debug("reading approach from: " + document.getName());
            return join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_Approach)));
        } catch (InternalProcessingException e) {
            logger.error("Error getting approach from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getBackground(){
        try {
            logger.debug("reading background from: " + document.getName());
            return join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_Background)));
        } catch (InternalProcessingException e) {
            logger.error("Error getting background from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getChallenge(){
        try {
            logger.debug("reading challenge from: " + document.getName());
            return join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_Challenge)));
        } catch (InternalProcessingException e) {
            logger.error("Error getting challenge from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getTerms(){
        try {
            logger.debug("reading terminology from: " + document.getName());
            return document.extractTerminology().stream().map(t->t.getText()).collect(Collectors.joining(", "));
        } catch (DRIexception e) {
            logger.error("Error getting terms from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getIntroduction(){
        try {
            logger.debug("reading introduction from: " + document.getName());
            return join(document.extractSections(false).stream().filter(s -> sectionHelper.isIntroduction(s)).flatMap(s -> s.getSentences().stream()));
        } catch (DRIexception e) {
            logger.error("Error getting introduction from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getConclusion(){
        try {
            logger.debug("reading conclusion from: " + document.getName());
            return join(document.extractSections(false).stream().filter(s -> sectionHelper.isConclusion(s)).flatMap(s -> s.getSentences().stream()));
        } catch (DRIexception e) {
            logger.error("Error getting conclusion from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public List<String> getSections() {
        try{
            return document.extractSections(false).stream().map(s -> s.getName()).collect(Collectors.toList());
        } catch (DRIexception e) {
            logger.error("Error getting sections from: " + document, e);
            throw new RuntimeException(e);
        }
    }


    private String join(Stream<Sentence> sentences){
        return sentences.map(s -> s.getText()).collect(Collectors.joining(" "));
    }

}
