package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class Token implements Serializable {

    String word;

    String pos;

    String lemma;

    boolean stopWord;

    public boolean isValid(){
        return !stopWord
                && lemma.length()>2
                && lemma.matches(".*[a-zA-Z]+.*");
    }
}
