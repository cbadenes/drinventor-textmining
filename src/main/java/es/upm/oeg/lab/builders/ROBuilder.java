package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.MetaInformation;
import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.epnoi.harvester.domain.ResearchSource;
import es.upm.oeg.lab.data.Item;
import es.upm.oeg.lab.data.Section;
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

    public static ResearchObject newInstance(Item item, Section.Type sectionType){

        // Check in DB
        String key = item.getRefPaper().getFilename() + "-" + sectionType.id;
        Optional<Object> data = StorageHelper.read(DB_TYPE, key);

        if (data.isPresent()){
            logger.debug("RO from item: '" + item.getRefPaper().getFilename() + "' read from DB");
            return (ResearchObject)data.get();
        }

        logger.debug("Creating RO from item: " + item);
        ResearchObject ro = new ResearchObject();
        ro.setUri(key);
        ro.setUrl(sectionType.id);

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

        // Content
        logger.debug("Reading section: " + sectionType + " from item: " + item);
        Section section = item.get(sectionType);
        ro.setContent(section.getText().getContent());

        // Bag-Of-Words
        List<String> bagOfWords = section.getText().getTokens().stream().filter(t -> t.isValid()).map(t -> t.getLemma().toLowerCase()).collect(Collectors.toList());
        ro.setBagOfWords(bagOfWords);

        logger.info("Saving ro from section: '"+sectionType.id + "' from: '" + item.getRefPaper().getFilename()+"'");
        StorageHelper.save(DB_TYPE,key,ro);

        return ro;
    }

    public static List<ResearchObject> newInstances(Item item){

        return Arrays.stream(Section.Type.values()).map(s -> newInstance(item,s)).collect(Collectors.toList());
    }

}
