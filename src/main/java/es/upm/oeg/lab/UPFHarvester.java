package es.upm.oeg.lab;

import es.upm.oeg.lab.builders.CorpusBuilder;
import es.upm.oeg.lab.builders.ItemBuilder;
import es.upm.oeg.lab.data.Corpus;
import es.upm.oeg.lab.data.Item;
import es.upm.oeg.lab.helpers.FileHelper;
import es.upm.oeg.lab.helpers.SparkHelper;
import lombok.Getter;
import org.apache.spark.api.java.JavaRDD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 26/10/15.
 *
 * Create text files from Annotated SIGGraph Files by content-levels, i.e. whole content, only abstract..
 *
 */
public class UPFHarvester {

    private static final Logger logger          = LoggerFactory.getLogger(UPFHarvester.class);

    private static final String dbId            = "harvest";

    @Getter
    private final Corpus corpus;

    public UPFHarvester(){
        this.corpus             = CorpusBuilder.load();
    }

    public List<Item> harvest(String baseDir) throws IOException {

        logger.info("Reading corpus from: " + baseDir);
        return FileHelper.list(baseDir, "xml").stream().map(p -> ItemBuilder.build(p,corpus.getPaper(p))).collect(Collectors.toList());

    }


    public static void main(String[] args) throws IOException {
        UPFHarvester harvester  = new UPFHarvester();
        harvester.harvest("/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf");
    }


}
