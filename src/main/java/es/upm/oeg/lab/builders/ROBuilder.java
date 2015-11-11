package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.MetaInformation;
import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.epnoi.harvester.domain.ResearchSource;
import es.upm.oeg.lab.data.Document;
import es.upm.oeg.lab.data.Item;
import es.upm.oeg.lab.data.Part;
import es.upm.oeg.lab.helpers.StorageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 26/10/15.
 */
public class ROBuilder {

    private static final Logger logger = LoggerFactory.getLogger(ROBuilder.class);

    private static final String DRI_URI = "drinventor/";

    public static final String DB_TYPE = "ro";

    public static ResearchObject newInstance(Item item){

        // Check in DB
        String key = item.getRefPaper().getFilename() + "-" + item.getPart().getType().id;
        Optional<Object> data = StorageHelper.read(DB_TYPE, key);

        if (data.isPresent()){
            logger.debug("RO from item: '" + item.getRefPaper().getFilename() + "' read from DB");
            return (ResearchObject)data.get();
        }

        logger.debug("Creating RO from item: " + item);
        ResearchObject ro = new ResearchObject();
        ro.setUri(key);
        ro.setUrl(item.getPart().getType().id);

        ResearchSource source = new ResearchSource();
        source.setName("SigGraph");
        source.setUri(item.getRefPaper().getFilename());
        source.setUrl(DRI_URI+"SigGraph");
        source.setProtocol("http");
        ro.setSource(source);

        ro.setResources(new ArrayList<>());

        MetaInformation metaInformation = new MetaInformation();
        metaInformation.setCreators(item.getAuthors());
        metaInformation.setDescription(item.getRefPaper().getDomain());
        metaInformation.setFormat("pdf");
        metaInformation.setLanguage("en");
        metaInformation.setPublished(item.getDate());
        metaInformation.setRights("GPLv2");
        metaInformation.setTitle(item.getTitle());
        ro.setMetainformation(metaInformation);


        logger.debug("Reading part: " + item.getPart().getType() + " from item: " + item);
        // Content
        ro.setContent(item.getPart().getText().getContent());

        // Bag-Of-Words
        List<String> bagOfWords = item.getPart().getText().getTokens().stream().filter(t -> t.isValid()).map(t -> t.getLemma().toLowerCase()).collect(Collectors.toList());
        ro.setBagOfWords(bagOfWords);

        logger.info("Saving ro from part: '"+item.getPart().getType().id + "' from: '" + item.getRefPaper().getFilename()+"'");
        StorageHelper.save(DB_TYPE,key,ro);

        return ro;
    }

    public static List<ResearchObject> newInstances(Document document){

        return Arrays.stream(Part.Type.values()).map(p -> ItemBuilder.build(document,p)).map(i -> ROBuilder.newInstance(i)).collect(Collectors.toList());
    }

}
