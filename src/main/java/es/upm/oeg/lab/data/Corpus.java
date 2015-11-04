package es.upm.oeg.lab.data;

import es.upm.oeg.lab.data.upf.AnnotatedDoc;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class Corpus {

    Logger logger = LoggerFactory.getLogger(Corpus.class);

    List<Paper> papers;

    List<AnnotatedDoc> validated;

    List<AnnotatedDoc> unknown;

    List<AnnotatedDoc> different;

    public void init(){
        this.validated  = new ArrayList<>();
        this.unknown    = new ArrayList<>();
        this.different  = new ArrayList<>();
    }

    public boolean isValid(AnnotatedDoc doc){
        String fileName = doc.getFileNameWithoutExt();
        String title    = doc.getTitle();

        List<Paper> found = papers.stream().filter(p -> StringUtils.substringBefore(p.filename,".pdf").equalsIgnoreCase(fileName)).collect(Collectors.toList());

        if (found.isEmpty()){
            logger.error("Article: '" + title + "' from file: " + fileName + " not in original corpus");
            unknown.add(doc);
            return false;
        }

        String origTitle = found.get(0).title.trim();
        if (!found.get(0).title.trim().equalsIgnoreCase(title)){
            logger.error("Two different articles for the same file: " + fileName+". It would be: '" + origTitle + "', but it really is: '" + title + "'");
            different.add(doc);
            return false;
        }

        validated.add(doc);
        return true;
    }

    public Paper getPaper(AnnotatedDoc doc){
        return papers.stream().filter(p->StringUtils.substringBefore(p.filename,".pdf").equalsIgnoreCase(doc.getFileNameWithoutExt())).findFirst().get();
    }

    public Paper getPaper(Path path){
        Paper paper = papers.stream().filter(p -> StringUtils.substringBefore(p.filename, ".pdf").equalsIgnoreCase(StringUtils.substringBefore(path.getFileName().toString(), "_PROC.xml"))).findFirst().get();
        return paper;
    }

    public List<Paper> listMissingPapers(){

        List<String> existing = validated.stream().map(d -> StringUtils.substringBefore(d.getFileName(), "_PROC.xml")).collect(Collectors.toList());

        return papers.stream().filter(p -> !existing.contains(StringUtils.substringBefore(p.filename,".pdf"))).collect(Collectors.toList());
    }
}
