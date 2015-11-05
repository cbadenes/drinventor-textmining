package es.upm.oeg.lab.harvesters;

import edu.upf.taln.dri.lib.exception.InternalProcessingException;
import edu.upf.taln.dri.lib.model.ext.Sentence;
import edu.upf.taln.dri.lib.model.ext.SentenceSelectorENUM;
import es.cbadenes.lab.test.IntegrationTest;
import es.upm.oeg.lab.builders.CorpusBuilder;
import es.upm.oeg.lab.data.Section;
import es.upm.oeg.lab.data.upf.AnnotatedDoc;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by cbadenes on 26/10/15.
 */
@Category(IntegrationTest.class)
public class UPFHarvesterTest {

    private static final Logger logger = LoggerFactory.getLogger(UPFHarvesterTest.class);

    private static final String CONTENT_ANNOTATED_TEST_PATH = "src/test/resources/acm-siggraph-2006-2014-upf";

    private static final String CONTEXT_ANNOTATED_TEST_PATH = "src/main/resources/siggraphpaperMetaFilenames.json";

    @Test
    public void buildROs() throws IOException {

        CorpusBuilder.harvest(CONTENT_ANNOTATED_TEST_PATH,CONTEXT_ANNOTATED_TEST_PATH);
    }

    @Test
    public void viewHierarchicalIntroduction(){
        AnnotatedDoc doc = new AnnotatedDoc(new File(CONTENT_ANNOTATED_TEST_PATH +"/sig2006/p519-weiss_PROC.xml").toPath());
        String introduction = doc.get(Section.Type.INTRODUCTION);
        logger.info(introduction);
    }

    @Test
    public void viewMultiPageIntroduction() throws InternalProcessingException {

        AnnotatedDoc doc = new AnnotatedDoc(new File(CONTENT_ANNOTATED_TEST_PATH +"/sig2008a/a108-tan_PROC.xml").toPath());
        List<Sentence> sentences = doc.getDocument().extractSentences(SentenceSelectorENUM.ALL);

        sentences.stream().
                filter(s -> s.getContainingSection() != null).
                filter(s -> s.getContainingSection().getName() != null).
                filter(s -> s.getContainingSection().getName().toLowerCase().contains("introduction")).
                forEach(s-> System.out.println(s.getText()));
    }

}

