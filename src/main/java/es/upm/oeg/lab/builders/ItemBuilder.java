package es.upm.oeg.lab.builders;

import es.upm.oeg.lab.data.Document;
import es.upm.oeg.lab.data.Item;
import es.upm.oeg.lab.data.Part;
import es.upm.oeg.lab.data.Section;
import es.upm.oeg.lab.helpers.StorageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 11/11/15.
 */
public class ItemBuilder {

    private static Logger logger = LoggerFactory.getLogger(ItemBuilder.class);

    public static String DB_TYPE = "items";

    public static Item build(Document document, Part.Type partType){

        // Read from DB
        String key = document.getRefPaper().getFilename()+"-"+partType.id;
        Optional<Object> data = StorageHelper.read(DB_TYPE, key);

        if (data.isPresent()){
            logger.info("Loading item: '" + key + "' from db");
            return (Item) data.get();
        }

        Item item = new Item();
        item.setAuthors(document.getAuthors());
        item.setDate(document.getDate());
        item.setRefPaper(document.getRefPaper());
        item.setTitle(document.getTitle());

        Part part = new Part();
        for (String partialPartType : partType.name().split("_")){
            part.add(document.get(Section.Type.valueOf(partialPartType)));
        }
        item.setPart(part);

        // Save to DB
        StorageHelper.save(DB_TYPE,key, item);

        return item;
    }

    public static List<Item> build(Document document, List<Part.Type> partTypes){

        return partTypes.stream().map( type -> ItemBuilder.build(document,type)).collect(Collectors.toList());
    }

}
