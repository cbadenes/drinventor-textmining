package es.upm.oeg.lab.data;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by cbadenes on 03/11/15.
 */
@Data
public class Section implements Serializable{

    private final Text text;
    private final Section.Type type;

    public enum Type {
        FULL("full"),
        ABSTRACT("abs"),
        APPROACH("app"),
        BACKGROUND("bkg"),
        CHALLENGE("chll"),
        CONCLUSION("con"),
        CSUMMARY("csum"),
        FUTURE("fwork"),
        INTRODUCTION("intr"),
        OUTCOME("out"),
        TERMS("term"),
        TSUMMARY("tsum");

        public final String id;

        Type(String id){
            this.id = id;
        }
    }

    public Section(Text text, Section.Type type){
        this.text = text;
        this.type = type;
    }

    public boolean isType(Section.Type type){
        return this.type.equals(type);
    }

    public boolean isEmpty(){
        return text == null || text.getTokens().isEmpty();
    }
}
