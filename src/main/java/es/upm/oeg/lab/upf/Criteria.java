package es.upm.oeg.lab.upf;

/**
 * Created by cbadenes on 26/10/15.
 */

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

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
}
