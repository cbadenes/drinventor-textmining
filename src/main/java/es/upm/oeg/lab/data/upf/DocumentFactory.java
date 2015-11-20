package es.upm.oeg.lab.data.upf;

import edu.upf.taln.dri.lib.Factory;
import edu.upf.taln.dri.lib.exception.DRIexception;
import edu.upf.taln.dri.lib.model.Document;
import edu.upf.taln.dri.lib.model.DocumentImpl;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

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

    private static AtomicInteger counter = new AtomicInteger(-1);

    static {

        // Set property file path
        Factory.setDRIPropertyFilePath(new File("./src/main/resources/DRIconfig.properties").getAbsolutePath());

        // Enable bibliography entry parsing
        Factory.setEnableBibEntryParsing(true);

    }

    protected static Document parse(Path path) throws DRIexception {
        logger.info("Loading annotated doc from: " + path);
        int count = counter.incrementAndGet();
        if (count != 0){
            try {Thread.sleep(30000);} catch (InterruptedException e) {e.printStackTrace();}
        }

        String extension = FilenameUtils.getExtension(path.toString()).toLowerCase();
        switch(extension){
            case "xml":
                logger.info("parsing annotated XML document: " + path);
                return Factory.createNewDocument(path.toString());
            case "pdf":
                logger.info("parsing PDF document: " + path);
                return Factory.getPDFloader().parsePDF(path.toFile());
            default:
                logger.info("parsing document: " + path);
                return Factory.createNewDocument(path.toString());
        }
    }

}
