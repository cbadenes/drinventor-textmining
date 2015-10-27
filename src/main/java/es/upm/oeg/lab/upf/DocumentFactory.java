package es.upm.oeg.lab.upf;

import edu.upf.taln.dri.lib.Factory;
import edu.upf.taln.dri.lib.exception.DRIexception;
import edu.upf.taln.dri.lib.model.Document;
import edu.upf.taln.dri.lib.model.ext.*;
import edu.upf.taln.dri.lib.model.graph.DependencyGraph;
import edu.upf.taln.dri.lib.model.graph.GraphTypeENUM;
import edu.upf.taln.dri.lib.model.graph.generic.GraphToStringENUM;
import edu.upf.taln.dri.lib.model.util.DocParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by cbadenes on 23/10/15.
 *
 * Requirements:
 *  -Xms1024m: minimum Java Heap
 *  -Xmx3000m: maximum Java Heap (better equal to 4Gb: -Xmx4096m)
 *  -DDRIpropertyFile=src/main/resources/DRIconfig.properties   ( or by Factory.setDRIPropertyFilePath)
 *
 */
public class DocumentFactory {

    private static final Logger logger = LoggerFactory.getLogger(DocumentFactory.class);

    private static final String DRI_RESOURCE_DIR_PATH = "/Users/cbadenes/Documents/OEG/Projects/DrInventor/resources/upf/DRIresources-1.0.4";

    private static final String BASE_DIR = "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf";

    static {

        // Set property file path
        Factory.setDRIPropertyFilePath(new File("./src/main/resources/DRIconfig.properties").getAbsolutePath());

        // Enable bibliography entry parsing
        Factory.setEnableBibEntryParsing(true);

    }

    protected static Document parse(Path path) throws DRIexception {
        logger.info("Getting document from previously processed XML file: " + path);
        return Factory.createNewDocument(path.toString());
    }

}
