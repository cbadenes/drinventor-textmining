package es.upm.oeg.lab.harvesters.upf;

import edu.upf.taln.dri.lib.Factory;
import edu.upf.taln.dri.lib.exception.DRIexception;
import edu.upf.taln.dri.lib.model.Document;
import edu.upf.taln.dri.lib.model.ext.*;
import edu.upf.taln.dri.lib.model.graph.GraphTypeENUM;
import edu.upf.taln.dri.lib.model.graph.generic.GraphToStringENUM;
import edu.upf.taln.dri.lib.model.util.DocParse;
import es.cbadenes.lab.test.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.List;

/**
 * Created by cbadenes on 26/10/15.
 */
@Category(IntegrationTest.class)
public class UPFAnalyzer {

    private static final String DRI_RESOURCE_DIR_PATH = "/Users/cbadenes/Documents/OEG/Projects/DrInventor/resources/upf/DRIresources-1.0.4";

    private static final String BASE_DIR = "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf";

    /**
     * Requirements:
     *  -Xms1024m: minimum Java Heap
     *  -Xmx3000m: maximum Java Heap (better equal to 4Gb: -Xmx4096m)
     *  -DDRIpropertyFile=src/main/resources/DRIconfig.properties   ( or by Factory.setDRIPropertyFilePath)
     *
     */
    @Test
    public void analyze() throws DRIexception {

        // Set property file path
        Factory.setDRIPropertyFilePath(new File("/Users/cbadenes/Projects/drinventor-upf/src/main/resources/DRIconfig.properties").getAbsolutePath());

        // Enable bibliography entry parsing?
        Factory.setEnableBibEntryParsing(true);


        // Getting document from previously processed XML file
        Document document = Factory.createNewDocument(BASE_DIR +"/sig2006/p805-irving_PROC.xml");

        // -> Name
        System.out.println("## Name: ");
        System.out.println("\t-"+document.getName());

        // -> Header
        Header header = document.extractHeader();

        System.out.println("## Title: ");
        System.out.println(header.getTitle());

        System.out.println("## Authors: ");
        List<Author> authors = header.getAuthorList();
        for(Author author: authors){
            System.out.println("\t-"+ author.getFullName());
        }

        System.out.println("## Year: ");
        System.out.println(header.getYear());

        System.out.println("## OpenURL: ");
        System.out.println(header.getOpenURL());

        System.out.println("## Institutions: ");
        List<Institution> institutions = header.getInstitutions();
        for(Institution institution: institutions){
            System.out.println("\t-"+ institution.getName() + " / " + institution.getCity() + " / " + institution.getState());
        }

        // -> Citations
        System.out.println("## Citations: ");
        List<Citation> citations = document.extractCitations();
        for(Citation citation: citations){
            System.out.println("\t-"+citation.getDoi() + " / " + citation.getSource() + " / " + citation.getYear());
        }

        // -> Sections
        System.out.println("## Sections: ");
        List<Section> sections = document.extractSections(true);
        for(Section section: sections){
            System.out.println("\t-["+ section.getLevel()+ "] " + section.getName() + "[" + section.getSentences().size() + "]");
        }

        // -> Summary
        System.out.println("## Summary by Centroid Section: ");
        List<Sentence> sumSentencesCentroid = document.extractSummary(10, SummaryTypeENUM.CENTROID_SECT);
        for (Sentence sentence: sumSentencesCentroid){
            System.out.println("\t-"+sentence.getText() + " -> " + sentence.getRhetoricalClass().name());
        }

        System.out.println("## Summary by Titile Section: ");
        List<Sentence> sumSentencesTitile = document.extractSummary(10, SummaryTypeENUM.TITILE_SIM);
        for (Sentence sentence: sumSentencesTitile){
            System.out.println("\t-"+sentence.getText() + " -> " + sentence.getRhetoricalClass().name());
        }

        // -> Terminology
        System.out.println("## Terminology: ");
        List<CandidateTermOcc> terms = document.extractTerminology();
        for (CandidateTermOcc term: terms){
            System.out.println("\t-"+term.getText());
        }

        // -> Abstract
        System.out.println("## Abstract: ");
        List<Sentence> abstractSentences = document.extractSentences(SentenceSelectorENUM.ONLY_ABSTRACT);
        for(Sentence sentence: abstractSentences){
            System.out.println("\t-"+sentence.getText() + " -> " + sentence.getRhetoricalClass().name());
            System.out.println("\t-"+document.extractSentenceGraph(sentence.getId(), GraphTypeENUM.COMPACT_SBJ_VERB_OBJ).graphAsString(GraphToStringENUM.TREE));
            System.out.println("\t-"+document.extractSentenceGraph(sentence.getId(), GraphTypeENUM.COMPACT_SBJ_VERB_OBJ).graphAsString(GraphToStringENUM.NODE_LIST));
        }

        // -> Sentence Graphs
        System.out.println("## Abstract Sentence Graph: ");
        String CSVtriples = DocParse.getROSasCSVstring(document, SentenceSelectorENUM.ONLY_ABSTRACT, GraphTypeENUM.COMPACT_SBJ_VERB_OBJ);
        System.out.println(CSVtriples);


    }
}
