package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by cbadenes on 20/11/15.
 */
@Data
public class Sentence implements Serializable {

    Optional<Token> subject;

    Optional<Token> verb;

    Optional<Token> directObject;

    Optional<Token> adverbialComplement;
}
