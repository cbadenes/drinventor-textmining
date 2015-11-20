package es.upm.oeg.lab.data.upf;

import edu.upf.taln.dri.lib.Factory;
import edu.upf.taln.dri.lib.exception.DRIexception;
import edu.upf.taln.dri.lib.exception.InternalProcessingException;
import edu.upf.taln.dri.lib.loader.PDFloader;
import edu.upf.taln.dri.lib.model.Document;
import edu.upf.taln.dri.lib.model.ext.*;
import es.upm.oeg.lab.data.Section;
import es.upm.oeg.lab.helpers.SectionHelper;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cbadenes on 26/10/15.
 */
public class AnnotatedDoc implements Serializable {

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
            return StringUtils.replace(document.getName(), "_PDFX.xml", "_PROC.xml");
        } catch (InternalProcessingException e) {
            logger.error("Error getting name from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getFileNameWithoutExt(){
        try{
            return StringUtils.substringBefore(document.getName(),"_PDFX.xml");
        } catch (InternalProcessingException e) {
            logger.error("Error getting name from: " + document, e);
            throw new RuntimeException(e);
        }
    }


    public String get(Section.Type sectionType){
        logger.debug("reading " + sectionType +" from: " + path);
        try{
            String text = "";
            switch (sectionType){
                case ABSTRACT:
                    text = join(this.document.extractSentences(SentenceSelectorENUM.ONLY_ABSTRACT).stream());
                    break;
                case FULL:
                    text = this.document.getRawText();
                    break;
                case APPROACH:
                    text = join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_Approach)));
                    break;
                case BACKGROUND:
                    text = join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_Background)));
                    break;
                case CHALLENGE:
                    text = join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_Challenge)));
                    break;
                case CONCLUSION:
                    text = join(document.extractSections(false).stream().filter(s -> sectionHelper.isConclusion(s)).flatMap(s -> s.getSentences().stream()));
                    break;
                case CENTROIDSUMM:
                    text = join(this.document.extractSummary(50, SummaryTypeENUM.CENTROID_SECT).stream());
                    break;
                case FUTURE:
                    text = join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_FutureWork)));
                    break;
                case INTRODUCTION:
                    text = join(document.extractSections(false).stream().filter(s -> sectionHelper.isIntroduction(s)).flatMap(s -> s.getSentences().stream()));
                    break;
                case OUTCOME:
                    text = join(sentences.stream().filter(s -> s.getRhetoricalClass().equals(RhetoricalClassENUM.DRI_Outcome)));
                    break;
                case TERMS:
                    text = document.extractTerminology().stream().map(t->t.getText()).collect(Collectors.joining(", "));
                    break;
                case TITLESUMM:
                    text = join(this.document.extractSummary(50, SummaryTypeENUM.TITILE_SIM).stream());
                    break;
                default:
                    throw new IllegalArgumentException("Section '" + sectionType.name() + "' not found in annotated document");
            }
            return text;
        } catch (DRIexception  e) {
            logger.error("Error getting text from: " + document, e);
            throw new RuntimeException(e);
        }
    }

    public String getTitle(){
        try{
            return this.document.extractHeader().getTitle().trim();
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
