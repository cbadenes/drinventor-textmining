package es.upm.oeg.lab.harvesters;

import es.upm.oeg.lab.data.Paper;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cbadenes on 17/11/15.
 */
public class XpathTest {

    private static final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<OAI-PMH xmlns=\"http://www.openarchives.org/OAI/2.0/\" xmlns:provenance=\"http://www.openarchives.org/OAI/2.0/provenance\" xmlns:oai_dc=\"http://www.openarchives.org/OAI/2.0/oai_dc/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\">\n" +
            "    <responseDate>2015-11-17T15:16:23Z</responseDate>\n" +
            "    <request verb=\"ListRecords\" metadataPrefix=\"oai_dc\" set=\"978-953-307-216-6\">http://www.intechopen.com/oai/index.php</request>\n" +
            "    <ListRecords>\n" +
            "        <record>\n" +
            "            <header>\n" +
            "                <identifier>oai:intechopen.com:13824</identifier>\n" +
            "                <datestamp>2011-02-04</datestamp>\n" +
            "                <setSpec>978-953-307-216-602011-02-04</setSpec>\n" +
            "            </header>\n" +
            "            <metadata>\n" +
            "                <dc>\n" +
            "                    <dc:title>Optimal Gait Generation in Biped Locomotion of Humanoid Robot to Improve Walking Speed</dc:title>\n" +
            "                    <dc:creator>Hanafiah Yussof</dc:creator>\n" +
            "                    <dc:creator>Mitsuhiro Yamano</dc:creator>\n" +
            "                    <dc:creator>Yasuo Nasu</dc:creator>\n" +
            "                    <dc:creator>Masahiro Ohka</dc:creator>\n" +
            "                    <dc:subject>Biped Robots</dc:subject>\n" +
            "                    <dc:publisher>InTech</dc:publisher>\n" +
            "                    <dc:date>2011-02-04</dc:date>\n" +
            "                    <dc:type>013</dc:type>\n" +
            "                    <dc:identifier>http://www.intechopen.com/articles/show/title/optimal-gait-generation-in-biped-locomotion-of-humanoid-robot-to-improve-walking-speed</dc:identifier>\n" +
            "                    <dc:language>en</dc:language>\n" +
            "                    <dc:relation>ISBN:978-953-307-216-6</dc:relation>\n" +
            "                    <dc:source>http://www.intechopen.com/download/pdf/pdfs_id/13824</dc:source>\n" +
            "                </dc>\n" +
            "            </metadata>\n" +
            "        </record>\n" +
            "    </ListRecords>\n" +
            "</OAI-PMH>\n";


    @Test
    public void readMetaInformation(){

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



            Document document = builder.parse(new ByteArrayInputStream(xml.getBytes()));



            String title    = xPath.evaluate("//title/text()",document);
            String authors  = xPath.evaluate("//creator[1]/text()",document);
            String doi      = xPath.evaluate("//relation/text()",document);
            String article  = xPath.evaluate("//subject/text()",document);

            Paper paper = new Paper();
            paper.setArticle(article);
            paper.setAuthors(authors);
            paper.setDoi(doi);
            paper.setTitle(title);


            System.out.println(paper);



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
