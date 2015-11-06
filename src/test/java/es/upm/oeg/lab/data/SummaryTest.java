package es.upm.oeg.lab.data;

import org.junit.Test;

import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by cbadenes on 05/11/15.
 */
public class SummaryTest {

    @Test
    public void statistics(){

        LongSummaryStatistics statistics = LongStream.of(3l, 4l, 5l).summaryStatistics();

        System.out.println(statistics);


    }
}
