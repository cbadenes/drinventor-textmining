package es.upm.oeg.lab.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbadenes on 26/10/15.
 */
public class FilesHelper {

    private static final Logger logger = LoggerFactory.getLogger(FilesHelper.class);

    private final ObjectWriter jacksonSerializer;


    public FilesHelper(){
        this.jacksonSerializer  = new ObjectMapper().writer().withDefaultPrettyPrinter();
    }


    public static Path path(String directory, String fileName){
        return Paths.get(directory,fileName);
    }

    public static void create(String directory){
        File baseDir = Paths.get(directory).toFile();
        if (!baseDir.exists()) baseDir.mkdirs();
    }

    public static Path create(String directory, String fileName){
        File baseDir = Paths.get(directory).toFile();
        if (!baseDir.exists()) baseDir.mkdirs();

        Path path = path(directory,fileName);
        if (path.toFile().exists()){
            try {
                Files.move(path,Paths.get(directory, fileName + "." + System.currentTimeMillis()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return path;
    }
    
    public static List<Path> list(String baseDir, String extension) throws IOException {
        Path dir = new File(baseDir).getAbsoluteFile().toPath();

        List<Path> files                = new ArrayList<>();
        PathMatcher matcher             = FileSystems.getDefault().getPathMatcher("glob:*."+ extension );
        DirectoryStream<Path> stream    = Files.newDirectoryStream(dir);

        for (Path path: stream) {

            if (matcher.matches(path.getFileName())){
                files.add(path);
            }
            if (path.toFile().isDirectory()){
                files.addAll(list(path.toString(), extension));
            }
        }

        return files;
    }

    public static void copyFolder(String source, String target) throws IOException {
        Path input  = Paths.get(source);
        Path output = Paths.get(target);
        FileUtils.copyDirectoryToDirectory(input.toFile(),output.toFile());
    }

    public  void write(Path path, String suffix, ResearchObject ro) throws IOException {
        // output path
        Path outFile = new File(path.toString()+"."+suffix).toPath();

        // JSON from Research Object
        String json = jacksonSerializer.writeValueAsString(ro);

        // create the new file
        Files.write(outFile, json.getBytes());
        logger.info("Wrote in: " + outFile.toString());
    }

}
