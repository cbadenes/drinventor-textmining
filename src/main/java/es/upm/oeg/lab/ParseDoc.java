package es.upm.oeg.lab;

import es.upm.oeg.lab.builders.DocumentBuilder;
import es.upm.oeg.lab.data.Paper;
import es.upm.oeg.lab.helpers.StorageHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by cbadenes on 18/11/15.
 */
public class ParseDoc {

    public static void main(String[] args){

        String dbPath   = args[0];

        //TODO receive a path to json file instead of meta-information
        String filePath = args[1];
        String fileName = args[2];
        String title    = args[3];
        String domain   = args[4];


        Path path = Paths.get(filePath);

        Paper paper = new Paper();
        paper.setArticle("");
        paper.setAuthors("");
        paper.setDoi("");
        paper.setFilename(fileName);
        paper.setTitle(title);
        paper.setDomain(domain);


        StorageHelper.DIRECTORY = dbPath;
        DocumentBuilder.build(path,paper);
    }

}
