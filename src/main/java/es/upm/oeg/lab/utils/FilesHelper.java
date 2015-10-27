package es.upm.oeg.lab.utils;

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

    public static List<Path> find(String baseDir, String fileExtension) throws IOException {
        Path dir = new File(baseDir).getAbsoluteFile().toPath();
        logger.info("finding files from: " + dir);

        List<Path> files                = new ArrayList<>();
        PathMatcher matcher             = FileSystems.getDefault().getPathMatcher("glob:*."+ fileExtension );
        DirectoryStream<Path> stream    = Files.newDirectoryStream(dir);

        for (Path path: stream) {

            if (matcher.matches(path.getFileName())){
                logger.info("adding file: " + path.toString());
                files.add(path);
            }
            if (path.toFile().isDirectory()){
                files.addAll(find(path.toString(), fileExtension));
            }
        }

        return files;
    }

}
