package es.upm.oeg.lab.data;

import es.upm.oeg.epnoi.harvester.domain.Creator;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class Document implements Serializable{

    Logger logger = LoggerFactory.getLogger(Document.class);

    Paper refPaper;

    List<Creator> authors;

    String date;

    String title;

    List<Section> sections = new ArrayList<>();


    public boolean isAnnotated(){
        return title != null;
    }

    public Document add(Section section){
        logger.info("Adding new section: " + section + " from Paper: " + refPaper);
        sections.add(section);
        return this;
    }

    public Section get(Section.Type sectionType){
        return sections.stream().filter(s -> s.isType(sectionType)).findFirst().get();
    }

    public String getName(){
        return StringUtils.substringBefore(refPaper.getFilename(),".pdf");
    }

    @Override
    public String toString(){
        StringBuilder description = new StringBuilder();
        description.append(refPaper);
        description.append("annotated?").append(isAnnotated());
        description.append(authors);
        description.append(" with ").append(sections.size()).append(" sections");
        return description.toString();
    }

}
