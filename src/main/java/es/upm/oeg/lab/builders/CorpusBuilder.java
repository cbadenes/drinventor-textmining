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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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

    public static Stream<Item> harvest(String contentAnnotatedCorpus, String contextAnnotatedCorpus) throws IOException {

        logger.info("Reading context annotations from: " + contextAnnotatedCorpus);
        List<Paper> papers = CorpusBuilder.load(contextAnnotatedCorpus).getPapers();


        logger.info("Reading content annotations from: " + contentAnnotatedCorpus);
        List<Path> xmls = FileHelper.list(contentAnnotatedCorpus, "xml");

        Map<String,Path> filePaths = new HashMap<>();
        xmls.stream().forEach(x -> filePaths.put(fileNameFromXml(x),x));

        logger.info("Creating items");
        return papers.stream().map(p -> ItemBuilder.build(filePaths.get(fileNameFromPdf(p.getFilename())), p));

    }

    public static JavaRDD<Item> harvestParallel(String contentAnnotatedCorpus, String contextAnnotatedCorpus) throws IOException {

        logger.info("Reading context annotations from: " + contextAnnotatedCorpus);
        List<Paper> papers = CorpusBuilder.load(contextAnnotatedCorpus).getPapers();

        JavaRDD<Paper> papersParallel = SparkHelper.sc.parallelize(papers);

        logger.info("Reading content annotations from: " + contentAnnotatedCorpus);
        Map<String,Path> filePaths = new HashMap<>();
        FileHelper.list(contentAnnotatedCorpus, "xml").stream().forEach(x -> filePaths.put(fileNameFromXml(x), x));

        logger.info("Creating items");
        return papersParallel.map(p -> ItemBuilder.build(filePaths.get(fileNameFromPdf(p.getFilename())), p));

    }

    private static String fileNameFromXml(Path path){
        String fileName = path.getFileName().toString();
        return StringUtils.substringBefore(fileName,"_PROC.xml");
    }

    private static String fileNameFromPdf(String fileName){
        return StringUtils.substringBefore(fileName,".pdf");
    }

}
