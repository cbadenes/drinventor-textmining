package es.upm.oeg.lab.harvester.upf;

/**
 * Created by cbadenes on 26/10/15.
 */

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Getter
public class Criteria{
    private boolean fullText            = false;
    private boolean abstracts           = false;
    private boolean centroidSummary     = false;
    private boolean titleSummary        = false;
    private boolean outcome             = false;
    private boolean futureWork          = false;
    private boolean approach            = false;
    private boolean background          = false;
    private boolean challenge           = false;
    private boolean terms               = false;
    private boolean introduction        = false;
    private boolean conclusion          = false;

    @Singular
    private Set<String> sections;

    public List<String> enabled(){
        List<String> values = new ArrayList<>();
        if (fullText)           values.add("full");
        if (abstracts)          values.add("abstract");
        if (centroidSummary)    values.add("csummary");
        if (titleSummary)       values.add("tsummary");
        if (outcome)            values.add("outcome");
        if (futureWork)         values.add("fwork");
        if (approach)           values.add("approach");
        if (background)         values.add("background");
        if (challenge)          values.add("challenge");
        if (terms)              values.add("terms");
        if (introduction)       values.add("introduction");
        if (conclusion)         values.add("conclusion");
        return values;
    }
}
