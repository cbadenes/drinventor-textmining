package es.upm.oeg.lab.data;

import es.upm.oeg.lab.builders.JsonBuilder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class Summary implements Serializable {

    String docName;

    String docTitle;

    List<NlpSummary> sections = new ArrayList<>();

    public void add(NlpSummary nlpSummary){
        sections.add(nlpSummary);
    }


    @Override
    public String toString(){
        return JsonBuilder.toJson(this);
    }
}
