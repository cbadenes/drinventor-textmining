package es.upm.oeg.lab.helpers;

import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.ws4j.RelatednessCalculator;
import edu.cmu.lti.ws4j.impl.*;

import java.util.List;

/**
 * Created by cbadenes on 20/11/15.
 */
public class WordNetSimHelper {

    private static ILexicalDatabase db = new NictWordNet();

    private static RelatednessCalculator hirstStOnge        = new HirstStOnge(db);

    private static RelatednessCalculator leacockChodorow    = new LeacockChodorow(db);

    private static RelatednessCalculator lesk               = new Lesk(db);

    private static RelatednessCalculator wuPalmer           = new WuPalmer(db);

    private static RelatednessCalculator resnik             = new Resnik(db);

    private static RelatednessCalculator jiangConrath       = new JiangConrath(db);

    private static RelatednessCalculator lin                = new Lin(db);

    private static RelatednessCalculator path               = new Path(db);


    public static double hirstStOnge(String word1, String word2){
        return hirstStOnge.calcRelatednessOfWords(word1,word2);
    }

    public static double leacockChodorow(String w1, String w2){
        return leacockChodorow.calcRelatednessOfWords(w1,w2);
    }

    public static double lesk(String w1, String w2){
        return lesk.calcRelatednessOfWords(w1,w2);
    }

    public static double wuPalmer(String w1, String w2){
        return wuPalmer.calcRelatednessOfWords(w1,w2);
    }

    public static double[][] wuPalmer(String[] s1, String[] s2){
        return wuPalmer.getNormalizedSimilarityMatrix(s1, s2);
    }

    public static double resnik(String w1, String w2){
        return resnik.calcRelatednessOfWords(w1,w2);
    }

    public static double jiangConrath(String w1, String w2){
        return jiangConrath.calcRelatednessOfWords(w1,w2);
    }

    public static double lin(String w1, String w2){
        return lin.calcRelatednessOfWords(w1,w2);
    }

    public static double[][] lin(String[] s1, String[] s2){
        return lin.getNormalizedSimilarityMatrix(s1,s2);
    }

    public static double path(String w1, String w2){
        return path.calcRelatednessOfWords(w1,w2);
    }

}
