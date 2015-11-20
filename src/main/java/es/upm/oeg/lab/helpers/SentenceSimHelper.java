package es.upm.oeg.lab.helpers;

import es.upm.oeg.lab.data.Sentence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cbadenes on 20/11/15.
 */
public class SentenceSimHelper {

    private static final Logger logger  = LoggerFactory.getLogger(SentenceSimHelper.class);

    private static double subjectWeight         = 0.52791;

    private static double verbWeight            = 0.59672;

    private static double objectWeight          = 0.47315;

    private static double advComplementWeight   = 0.22383;


    /**
     * Implementation of W-SyMSS (Oliva et al. 2011) with the optimal weights published at Serrano et al. 2015
     * 'Human-inspired semantic similarity between sentences'
     * @param s1
     * @param s2
     * @return
     */
    public static double calculateRelatedness(Sentence s1, Sentence s2){

        Double subjectSim   = (s1.getSubject().isPresent() && s2.getSubject().isPresent())? WordNetSimHelper.wuPalmer(s1.getSubject().get().getWord(),s2.getSubject().get().getWord()) : 0.0;
        Double verbSim      = (s1.getVerb().isPresent() && s2.getVerb().isPresent())? WordNetSimHelper.wuPalmer(s1.getVerb().get().getWord(),s2.getVerb().get().getWord()) : 0.0;
        Double objectSim    = (s1.getDirectObject().isPresent() && s2.getDirectObject().isPresent())? WordNetSimHelper.wuPalmer(s1.getDirectObject().get().getWord(),s2.getDirectObject().get().getWord()) : 0.0;
        Double advComplSim  = (s1.getAdverbialComplement().isPresent() && s2.getAdverbialComplement().isPresent())? WordNetSimHelper.wuPalmer(s1.getAdverbialComplement().get().getWord(),s2.getAdverbialComplement().get().getWord()) : 0.0;

        double sim = (subjectWeight*subjectSim) + (verbWeight*verbSim) + (objectWeight*objectSim) + (advComplementWeight*advComplSim) / (subjectWeight + verbWeight + objectWeight + advComplementWeight);
        logger.info("Similarity between " + s1 + " and " + s2 + " is: " + sim);
        return sim;

    }
}
