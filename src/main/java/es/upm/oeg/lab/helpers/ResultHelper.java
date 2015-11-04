package es.upm.oeg.lab.helpers;

import au.com.bytecode.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by cbadenes on 29/10/15.
 */
public class ResultHelper {

    private static final Logger logger      = LoggerFactory.getLogger(ResultHelper.class);

    public static final String DIRECTORY    = "acm-siggraph-2006-2014-upf-results";

    private final CSVWriter writer;
    private final Path path;

    public ResultHelper(String id){
        String fileName     = id + ".csv";
        try {
            this.path   = FileHelper.create(DIRECTORY, fileName);
            this.writer = new CSVWriter(new FileWriter(path.toString()), ',');
        } catch (IOException e) {
            logger.error("error creating the file: " + fileName);
            throw new RuntimeException(e);
        }
    }

    public void add(List<String> result){
        this.writer.writeNext(result.toArray(new String[result.size()]));
    }

    public void finish(){
        try {
            this.writer.close();
            logger.info("File: " + path + " wrote successfully");
        } catch (IOException e) {
            logger.error("error writing file: " + path);
            throw new RuntimeException(e);
        }
    }
}
