package es.upm.oeg.lab.analyzers;

import es.upm.oeg.lab.data.Section;

import java.io.File;

/**
 * Created by cbadenes on 30/10/15.
 */
public abstract class ROAnalyzer {

    protected static final String  RO_FOLDER = "acm-siggraph-2006-2014-upf-ros";


    protected String getROPath(Section.Type sectionType){
        return RO_FOLDER + File.separator + "*." + sectionType.id;
    }



}
