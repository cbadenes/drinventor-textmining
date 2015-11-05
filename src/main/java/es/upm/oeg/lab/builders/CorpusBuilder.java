package es.upm.oeg.lab.builders;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.upm.oeg.lab.data.Corpus;
import es.upm.oeg.lab.data.Item;
import es.upm.oeg.lab.data.Paper;
import es.upm.oeg.lab.helpers.FileHelper;
import es.upm.oeg.lab.helpers.SparkHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.api.java.JavaRDD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by cbadenes on 02/11/15.
 *
 * Create text files from Annotated SIGGraph Files by content-levels, i.e. whole content, only abstract..
 *
 */
public class CorpusBuilder {

    private static final Logger logger = LoggerFactory.getLogger(CorpusBuilder.class);

    public static Corpus load(String filePath){

        ObjectMapper mapper = new ObjectMapper();
        try {
            Corpus corpus = mapper.readValue(new File(filePath), Corpus.class);
            corpus.init();
            return corpus;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static JavaRDD<Item> harvest(String contentAnnotatedCorpus, String contextAnnotatedCorpus) throws IOException {

        logger.info("Reading context annotations from: " + contextAnnotatedCorpus);
        JavaRDD<Paper> papers = SparkHelper.sc.parallelize(CorpusBuilder.load(contextAnnotatedCorpus).getPapers());


        logger.info("Reading content annotations from: " + contentAnnotatedCorpus);
        return papers.map(p -> ItemBuilder.build(pathByPaperName(contentAnnotatedCorpus, p.getFilename()), p));

    }

    private static Path pathByPaperName(String baseDir, String contextFileName) throws IOException {
        String name     = StringUtils.substringBefore(contextFileName, ".pdf");
        String fileName =  name + "_PROC.xml";
        return Paths.get(baseDir,fileName);
    }

}
