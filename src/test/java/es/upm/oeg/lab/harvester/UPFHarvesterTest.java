package es.upm.oeg.lab.harvester;

import edu.upf.taln.dri.lib.exception.InternalProcessingException;
import edu.upf.taln.dri.lib.model.ext.Sentence;
import edu.upf.taln.dri.lib.model.ext.SentenceSelectorENUM;
import es.cbadenes.lab.test.IntegrationTest;
import es.upm.oeg.lab.harvester.upf.AnnotatedDoc;
import es.upm.oeg.lab.harvester.upf.Criteria;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cbadenes on 26/10/15.
 */
@Category(IntegrationTest.class)
public class UPFHarvesterTest {

    private static final Logger logger = LoggerFactory.getLogger(UPFHarvesterTest.class);

    private static final String CORPUS_TEST_PATH = "src/test/resources/acm-siggraph-2006-2014-upf";

    private UPFHarvester harvester;

    @Before
    public void setup(){
        this.harvester = new UPFHarvester(CORPUS_TEST_PATH);
    }

    @Test
    public void buildROs(){

        String to           = "target/output";
        Boolean flatMode    = true;
        Criteria by         = Criteria.builder().
                fullText(true).
                abstracts(true).
                centroidSummary(true).
                titleSummary(true).
                outcome(true).
                futureWork(true).
                approach(true).
                background(true).
                challenge(true).
                introduction(true).
                conclusion(true).
                build();

        harvester.buildROs(to, by, flatMode);
    }

    @Test
    public void viewAllSections(){
        Map<String,Integer> record = new HashMap<>();

        logger.info("Number of papers: " + harvester.getDocuments().size());
        this.harvester.getDocuments().stream().forEach(d -> d.getSections().stream().forEach(s -> record.put(s, record.getOrDefault(s, 0) + 1)));
        record.keySet().stream().sorted().forEach(k -> logger.info("" + k + ": " + record.get(k)));
    }

    @Test
    public void viewAllIntroductions(){
        this.harvester.getDocuments().stream().forEach(d -> logger.info("Document: " + d.getFileName() + ". \n " + d.getIntroduction()));
    }

    @Test
    public void viewHierarchicalIntroduction(){
        AnnotatedDoc doc = new AnnotatedDoc(new File(CORPUS_TEST_PATH+"/sig2006/p519-weiss_PROC.xml").toPath());
        String introduction = doc.getIntroduction();
        logger.info(introduction);
    }

    @Test
    public void viewMultiPageIntroduction() throws InternalProcessingException {

        AnnotatedDoc doc = new AnnotatedDoc(new File(CORPUS_TEST_PATH+"/sig2008a/a108-tan_PROC.xml").toPath());
        List<Sentence> sentences = doc.getDocument().extractSentences(SentenceSelectorENUM.ALL);

        sentences.stream().
                filter(s -> s.getContainingSection() != null).
                filter(s -> s.getContainingSection().getName() != null).
                filter(s -> s.getContainingSection().getName().toLowerCase().contains("introduction")).
                forEach(s-> System.out.println(s.getText()));
    }

}

