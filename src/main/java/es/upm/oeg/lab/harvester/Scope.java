package es.upm.oeg.lab.harvester;

/**
 * Created by cbadenes on 29/10/15.
 */
public enum Scope {
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

    Scope(String id){
        this.id = id;
    }
}
