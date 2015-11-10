package es.upm.oeg.lab;

import es.cbadenes.lab.test.IntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;

/**
 * Created by cbadenes on 02/11/15.
 */
@Category(IntegrationTest.class)
public class AnalyzerTest {

    private Analyzer analyzer;

    @Before
    public void setup(){
        this.analyzer = new Analyzer();
    }

    @Test
    public void testCorpus() throws IOException {
        analyzer.analyze(
                "src/test/resources/acm-siggraph-2006-2014-upf",
                "src/main/resources/siggraphpaperMetaFilenames.json",
                10,
                100,
                10
        );
    }
}
