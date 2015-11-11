package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.Creator;
import es.upm.oeg.lab.data.Document;
import es.upm.oeg.lab.data.Paper;
import es.upm.oeg.lab.data.Part;
import es.upm.oeg.lab.data.Section;
import es.upm.oeg.lab.data.upf.AnnotatedDoc;
import es.upm.oeg.lab.helpers.StanfordNLPHelper;
import es.upm.oeg.lab.helpers.StorageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 02/11/15.
 */
public class DocumentBuilder {

    private static final Logger logger = LoggerFactory.getLogger(DocumentBuilder.class);

    private static final StanfordNLPHelper nlpHelper = new StanfordNLPHelper();

    public static final String DB_TYPE = "docs";

    public static Document build(Path path, Paper paper){

        // Read from DB
        String key = paper.getFilename();
        Optional<Object> data = StorageHelper.read(DB_TYPE, key);

        if (data.isPresent()){
            logger.info("Loading document: '" + key + "' from db");
            return (Document) data.get();
        }

        // Initialize Item
        Document document = new Document();
        // Ref Paper
        document.setRefPaper(paper);

        if (path.toFile().exists()){
            logger.info("Creating an internal document from the annotated document file: '" + path.toString() + "'");
            // Read annotated Doc
            AnnotatedDoc doc = new AnnotatedDoc(path);
            // Title
            document.setTitle(doc.getTitle().trim());
            // Authors
            List<Creator> authors = doc.getAuthors().stream().map(a -> CreatorBuilder.newInstance().addName(a.getFirstName()).addSurname(a.getSurname()).build()).collect(Collectors.toList());
            document.setAuthors(authors);
            // Year
            document.setDate(doc.getYear());
            // Sections
            Arrays.stream(Section.Type.values()).forEach(s -> document.add(new Section(nlpHelper.parse(doc.get(s)), s)));
        }else{
            logger.error("Paper does not annotated: " + paper);
        }

        // Save to DB
        StorageHelper.save(DB_TYPE,key, document);

        return document;
    }

}
