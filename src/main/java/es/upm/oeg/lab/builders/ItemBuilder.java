package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.Creator;
import es.upm.oeg.lab.data.Item;
import es.upm.oeg.lab.data.Paper;
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
public class ItemBuilder {

    private static final Logger logger = LoggerFactory.getLogger(ItemBuilder.class);

    private static final StanfordNLPHelper nlpHelper = new StanfordNLPHelper();

    private static final String DB_TYPE = "items";

    public static Item build(Path path, Paper paper){

        // Read from DB
        String key = paper.getFilename();
        Optional<Object> data = StorageHelper.read(DB_TYPE, key);

        if (data.isPresent()){
            logger.info("Loading item: '" + key + "' from db");
            return (Item) data.get();
        }

        logger.info("Creating item from annotated document: '" + path.toString() + "'");

        // Initialize Item
        Item item = new Item();
        // Ref Paper
        item.setRefPaper(paper);

        if (path.toFile().exists()){
            // Read annotated Doc
            AnnotatedDoc doc = new AnnotatedDoc(path);
            // Title
            item.setTitle(doc.getTitle().trim());
            // Authors
            List<Creator> authors = doc.getAuthors().stream().map(a -> CreatorBuilder.newInstance().addName(a.getFirstName()).addSurname(a.getSurname()).build()).collect(Collectors.toList());
            item.setAuthors(authors);
            // Year
            item.setDate(doc.getYear());
            // Sections
            Arrays.stream(Section.Type.values()).forEach(s -> item.add(new Section(nlpHelper.parse(doc.get(s)), s)));
        }else{
            logger.error("Paper does not annotated: " + paper);
        }

        // Save to DB
        StorageHelper.save(DB_TYPE,key,item);

        return item;
    }

}
