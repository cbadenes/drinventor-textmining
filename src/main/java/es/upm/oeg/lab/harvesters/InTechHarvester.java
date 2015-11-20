package es.upm.oeg.lab.harvesters;

import com.google.common.io.Files;
import es.upm.oeg.lab.data.Corpus;
import es.upm.oeg.lab.data.MetaFilename;
import es.upm.oeg.lab.data.Paper;
import es.upm.oeg.lab.helpers.FilesHelper;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by cbadenes on 17/11/15.
 */
public class InTechHarvester {


    public static void createMetaFilenames(String inputDirectory, String outputDirectory, String metaFile) throws IOException {

        // Papers
        List<Paper> papers = new ArrayList<>();

        File outDir = new File(outputDirectory);
        outDir.mkdirs();

        DocumentBuilder builder = null;
        try {
            // DOM Builder
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builder = builderFactory.newDocumentBuilder();

            // XPath Builder
            XPath xPath = XPathFactory.newInstance().newXPath();

            Map<String,String> nsMap = new HashMap<>();
            nsMap.put("oai", "http://www.openarchives.org/OAI/2.0/");
            nsMap.put("dc", "http://purl.org/dc/elements/1.1/");
            nsMap.put("provenance", "http://www.openarchives.org/OAI/2.0/provenance");
            nsMap.put("oai_dc", "http://www.openarchives.org/OAI/2.0/oai_dc/");
            nsMap.put("rss", "http://purl.org/rss/1.0/");
            NamespaceContext ns = new SimpleNamespaceContext(nsMap);

            xPath.setNamespaceContext(ns);

            // Hoarder Meta-Files
            List<Path> files = FilesHelper.list(inputDirectory, "xml");
            Integer index = 0;
            for (Path path: files){

                Paper paper = new Paper();


                String domain   = StringUtils.substringBefore(StringUtils.substringAfter(path.toString(), "oaipmh/"), "/");


                Document document = builder.parse(new FileInputStream(path.toString()));

                String title    = xPath.evaluate("//title/text()", document);
                String authors  = xPath.evaluate("//creator[1]/text()", document);
                String doi      = xPath.evaluate("//relation/text()", document);
                String article  = xPath.evaluate("//subject/text()", document);


                paper.setArticle(article);
                paper.setAuthors(authors);
                paper.setDoi(doi);
                paper.setDomain(domain);
                paper.setTitle(title);

                // Rename both files (xml and pdf) with domain
                String fileName     = StringUtils.replace(path.getFileName().toString(),".xml",".pdf");
                String newFileName  = domain+"-"+index+".pdf";

                index += 1;
                paper.setFilename(newFileName);
                Files.copy(Paths.get(path.getParent().toString(),fileName).toFile(),Paths.get(outputDirectory,newFileName).toFile());


                System.out.println("Paper: " + paper);
                papers.add(paper);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }


        // write papers to json in file
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        MetaFilename corpus = new MetaFilename();
        corpus.setPapers(papers);
        String json = mapper.writeValueAsString(corpus);
        Files.write(json,new File(metaFile), Charset.forName("UTF-8"));
    }



    public static void main(String[] args) throws IOException {
        String inputDirectory   = "hoarder/epnoi-hoarder-1.1.0/publications/oaipmh";
        String outputDirectory  = "corpus-intech/papers";
        String metaFile         = "corpus-intech/ref/corpus.json";
        InTechHarvester.createMetaFilenames(inputDirectory,outputDirectory,metaFile);
    }

}
