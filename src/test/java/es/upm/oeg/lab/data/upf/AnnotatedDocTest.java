package es.upm.oeg.lab.data.upf;

import es.cbadenes.lab.test.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by cbadenes on 02/11/15.
 */
@Category(IntegrationTest.class)
public class AnnotatedDocTest {

    @Test
    public void readFile(){

        Path path = Paths.get("/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf","sig2009/a33-gal_PROC.xml");

        AnnotatedDoc doc = new AnnotatedDoc(path);

//        System.out.println(doc.getTitle());

        System.out.println(doc.getFileName());

    }
}
