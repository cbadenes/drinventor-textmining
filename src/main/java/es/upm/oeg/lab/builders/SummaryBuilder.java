package es.upm.oeg.lab.builders;

import es.upm.oeg.lab.data.*;

import java.util.List;

/**
 * Created by cbadenes on 02/11/15.
 */
public class SummaryBuilder {

    public static Summary newInstance(Item item){
        Summary summary = new Summary();

        summary.setDocTitle(item.getTitle());
        summary.setDocName(item.getRefPaper().getFilename());

        NlpSummary nlpSummary = measure(item.getPart().getText());
        nlpSummary.setName(item.getRefPaper().getFilename());
        nlpSummary.setLabel(item.getPart().getType().id);
        summary.add(nlpSummary);
        return summary;
    }

    private static NlpSummary measure(Text text){

        List<Token> tokens = text.getTokens();

        NlpSummary summary = new NlpSummary();

        summary.setNumSentences(Long.valueOf(text.getNumSentences()));
        summary.setNumTokens(tokens.stream().count());
        summary.setNumWords(tokens.stream().map(t -> t.getWord()).distinct().count());
        summary.setNumLemmas(tokens.stream().map(t -> t.getLemma()).distinct().count());

        summary.setNumIN(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.IN.name())).count());
        summary.setNumJJ(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.JJ.name())).count());
        summary.setNumNN(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.NN.name())).count());
        summary.setNumNNP(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.NNP.name())).count());
        summary.setNumNNPS(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.NNPS.name())).count());
        summary.setNumRB(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.RB.name())).count());
        summary.setNumRP(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.RP.name())).count());
        summary.setNumVB(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.VB.name())).count());
        summary.setNumVBD(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.VBD.name())).count());
        summary.setNumVBN(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.VBN.name())).count());
        summary.setNumVBP(tokens.stream().filter(t -> t.getPos().equalsIgnoreCase(POS.VBP.name())).count());

        return summary;
    }
}
