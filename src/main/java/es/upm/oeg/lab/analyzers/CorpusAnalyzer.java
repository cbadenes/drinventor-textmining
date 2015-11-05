package es.upm.oeg.lab.analyzers;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.lab.builders.CorpusBuilder;
import es.upm.oeg.lab.builders.ROBuilder;
import es.upm.oeg.lab.data.Corpus;
import es.upm.oeg.lab.data.Paper;
import es.upm.oeg.lab.helpers.FileHelper;
import es.upm.oeg.lab.helpers.ResultHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by cbadenes on 29/10/15.
 */
public class CorpusAnalyzer extends ROAnalyzer {

    Logger logger = LoggerFactory.getLogger(CorpusAnalyzer.class);

    public void analyze() throws IOException {
//        ResultHelper resultHelper   = new ResultHelper("corpus.category");
//
//        Map<String,Paper> papers = new HashMap<>();
//        Map<String,ResearchObject> ros = new HashMap<>();
//
//        // Load original corpus
//        for (Paper paper: CorpusBuilder.load().getPapers()){
//            String fileName = StringUtils.substringBefore(paper.getFilename(), ".pdf").toLowerCase();
//            String title    = paper.getTitle().trim().toLowerCase();
//            logger.info("Paper name: '" + fileName + "' from file: " + paper.getFilename() + " with title: '" + title + "'");
//            papers.put(fileName,paper);
//        }
//
//        // Load UPF-processed corpus
//        for (Path path: FileHelper.listByExtension("acm-siggraph-2006-2014-upf-ros", "abs")){
//            ResearchObject ro = ROBuilder.fromJson(path.toFile());
//            String fileName = StringUtils.substringBefore(StringUtils.substringAfter(ro.getUri(), "-"), "_PROC.xml").toLowerCase();
//            String title    = ro.getMetainformation().getTitle().trim().toLowerCase();
//            logger.info("UPF paper name: '" + fileName + "' from file: " + ro.getUri() + " with title: '" + title + "'");
//            ros.put(fileName,ro);
//        }
//
//        StringBuilder missingArticles       = new StringBuilder();
//        StringBuilder conflictingArticles   = new StringBuilder();
//
//        for(String file: papers.keySet()){
//            if (!ros.containsKey(file)){
//                missingArticles.append("- Article: '" + papers.get(file).getTitle() + "'("+file+") not in the UPF-processed corpus").append("\n");
//                continue;
//            }
//
//            String origTitle    = papers.get(file).getTitle().trim().toLowerCase();
//            String upfTitle     = ros.get(file).getMetainformation().getTitle().trim().toLowerCase();
//            if (!origTitle.equals(upfTitle)){
//                conflictingArticles.append("File '"+file+"': \n");
//                conflictingArticles.append("- said to be: '" + origTitle + "'\n");
//                conflictingArticles.append("- but it is: '" + upfTitle + "'\n");
//            }
//
//        }
//
//        for(String file: ros.keySet()){
//            if (!papers.containsKey(file)){
//                missingArticles.append("- Article: '" + ros.get(file).getMetainformation().getTitle() + "'(" + file + ") not in the original corpus").append("\n");
//                continue;
//            }
//
//        }
//
//        logger.info("Size of original corpus: " + papers.keySet().size());
//        logger.info("Size of UPF-Processed corpus: " + ros.keySet().size());
//
//        logger.info("Missing Articles: ");
//        logger.info("\n"+ missingArticles.toString());
//
//        logger.info("Conflicting Articles: ");
//        logger.info("\n"+ conflictingArticles.toString());
//
//
//
//        resultHelper.finish();
    }


    public static void main(String[] args) throws IOException {

        CorpusAnalyzer analyzer = new CorpusAnalyzer();

        analyzer.analyze();


    }
}
