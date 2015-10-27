package es.upm.oeg.lab.harvester;

import edu.upf.taln.dri.lib.exception.InternalProcessingException;
import edu.upf.taln.dri.lib.model.ext.Sentence;
import edu.upf.taln.dri.lib.model.ext.SentenceSelectorENUM;
import es.upm.oeg.lab.hoarder.AnnotatedDocHoarder;
import es.upm.oeg.lab.upf.AnnotatedDoc;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cbadenes on 26/10/15.
 */
public class SectionTest {

    private AnnotatedDocHoarder handler;

    public void setup(){

    }

    public void checkSections(){

        this.handler = new AnnotatedDocHoarder("src/test/resources/acm-siggraph-2006-2014-upf");
        Map<String,Integer> record = new HashMap<>();

        System.out.println("Number of papers: " + handler.getDocuments().size());

        this.handler.getDocuments().stream().forEach(d -> d.getSections().stream().forEach(s -> record.put(s, record.getOrDefault(s, 0) + 1)));

        record.keySet().stream().sorted().forEach(k -> System.out.println("" + k + ": " + record.get(k)));

    }


    public void printIntroductions(){

        this.handler = new AnnotatedDocHoarder("src/test/resources/acm-siggraph-2006-2014-upf");
        this.handler.getDocuments().stream().forEach(d -> System.out.println("Document: " + d.getFileName() + ". \n " + d.getIntroduction()));

    }


    public void printHierarchicalIntroduction(){

        AnnotatedDoc doc = new AnnotatedDoc(new File("src/test/resources/acm-siggraph-2006-2014-upf/sig2006/p519-weiss_PROC.xml").toPath());
        String introduction = doc.getIntroduction();
        System.out.println(introduction);

    }

    public void printMultipleIntroduction() throws InternalProcessingException {

        AnnotatedDoc doc = new AnnotatedDoc(new File("src/test/resources/acm-siggraph-2006-2014-upf/sig2008a/a108-tan_PROC.xml").toPath());
        List<Sentence> sentences = doc.getDocument().extractSentences(SentenceSelectorENUM.ALL);

        sentences.stream().
                filter(s -> s.getContainingSection() != null).
                filter(s -> s.getContainingSection().getName() != null).
                filter(s -> s.getContainingSection().getName().toLowerCase().contains("introduction")).
                forEach(s-> System.out.println(s.getText()));


    }

}

