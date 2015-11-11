package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 03/11/15.
 */
@Data
public class Part implements Serializable{

    private Text text;
    private Part.Type type;

    public enum Type {
        FULL("full"),
        ABSTRACT("abs"),
        APPROACH("app"),
        BACKGROUND("bkg"),
        CHALLENGE("chll"),
        CONCLUSION("con"),
        CENTROIDSUMM("csum"),
        FUTURE("fwork"),
        INTRODUCTION("intr"),
        OUTCOME("out"),
        TERMS("term"),
        TITLESUMM("tsum"),
        INTRODUCTION_CONCLUSION("i_c"),
        APPROACH_FUTURE("a_f"),
        APPROACH_CHALLENGE("a_ch"),
        APPROACH_CONCLUSION("a_co"),
        APPROACH_INTRODUCTION("a_i"),
        FUTURE_CHALLENGE("f_ch"),
        FUTURE_CONCLUSION("f_co"),
        FUTURE_INTRODUCTION("f_i"),
        APPROACH_FUTURE_INTRODUCTION("a_f_i"),
        APPROACH_FUTURE_CONCLUSION("a_f_co"),
        ;

        public final String id;

        Type(String id){
            this.id = id;
        }

        public static List<Type> units(){
            return Arrays.stream(values()).filter(s -> !s.name().contains("_")).collect(Collectors.toList());
        }
    }

    public Part(Text text, Part.Type type){
        this.text = text;
        this.type = type;
    }

    public Part(){
        this.text = new Text();
        this.type = null;
    }

    public boolean isType(Part.Type type){
        return this.type.equals(type);
    }

    public boolean isEmpty(){
        return text == null || text.getTokens().isEmpty();
    }

    public Part add(Section section){

        this.text.content       += section.getText().getContent();
        this.text.numSentences  += section.getText().getNumSentences();
        this.text.tokens.addAll(section.getText().getTokens());


        this.type = (this.type == null)? Part.Type.valueOf(section.getType().name()) : Part.Type.valueOf(this.type.name()+"_"+section.getType().name());

        return this;
    }
}
