package es.upm.oeg.lab.builders;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.upm.oeg.lab.data.Corpus;

import java.io.File;
import java.io.IOException;

/**
 * Created by cbadenes on 02/11/15.
 */
public class CorpusBuilder {

    public static Corpus load(){

        ObjectMapper mapper = new ObjectMapper();
        try {
            Corpus corpus = mapper.readValue(new File("src/main/resources/siggraphpaperMetaFilenames.json"), Corpus.class);
            corpus.init();
            return corpus;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
