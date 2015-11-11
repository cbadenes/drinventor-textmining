package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class Text implements Serializable {

    String content = "";

    Integer numSentences = 0;

    List<Token> tokens = new ArrayList<>();

    public void add(Token token){
        this.tokens.add(token);
    }

    @Override
    public String toString(){
        StringBuilder description = new StringBuilder();

        description.append("TextInfo[");
        description.append("numSentences: ").append(numSentences).append(", ");
        description.append("numTokens: ").append(tokens.size());
        description.append("]");
        return description.toString();
    }
}
