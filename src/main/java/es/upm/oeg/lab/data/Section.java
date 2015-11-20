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
        CENTROIDSUMM("csum"),
        FUTURE("fwork"),
        INTRODUCTION("intr"),
        OUTCOME("out"),
        TERMS("term"),
        TITLESUMM("tsum")
        ;

        public final String id;

        Type(String id){
            this.id = id;
        }

        public static List<Type> units(){
            return Arrays.stream(values()).filter(s -> !s.name().contains("_")).collect(Collectors.toList());
        }

        public static boolean contains(String value){
            return Arrays.stream(Type.values()).filter(t -> t.id.equalsIgnoreCase(value)).count() > 0;
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
