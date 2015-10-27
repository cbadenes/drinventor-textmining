package es.upm.oeg.lab.utils;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by cbadenes on 26/10/15.
 */
public class PathTests {

    @Test
    public void concatenatePaths(){

        Path path1 = new File("./directory/sample.txt").toPath();

        Path path2 = new File("sample.txt.full").toPath();

        System.out.println("Direct: " + Paths.get(path1.toString(),path2.toString()).toString());

        System.out.println("Parent: " + Paths.get(path1.getParent().toString(), path2.toString()).toString());

    }

}
