package es.upm.oeg.lab.helpers;

import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.ws4j.RelatednessCalculator;
import edu.cmu.lti.ws4j.impl.*;
import edu.cmu.lti.ws4j.util.WS4JConfiguration;
import org.junit.Test;

/**
 * Created by cbadenes on 20/11/15.
 */
public class WordNetSimilarityHelperTest {

    private static ILexicalDatabase db = new NictWordNet();
    private static RelatednessCalculator[] rcs = {
            new HirstStOnge(db), new LeacockChodorow(db), new Lesk(db),  new WuPalmer(db),
            new Resnik(db), new JiangConrath(db), new Lin(db), new Path(db)
    };


    @Test
    public void words(){

        String w1   = "sample";

        String w2   = "example";

        WS4JConfiguration.getInstance().setMFS(true);
        for ( RelatednessCalculator rc : rcs ) {
            double s = rc.calcRelatednessOfWords(w1, w2);
            System.out.println( rc.getClass().getName()+"\t"+s );
        }



    }
}
