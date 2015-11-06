package es.upm.oeg.lab.helpers;

import es.upm.oeg.lab.builders.BoxplotItemBuilder;
import es.upm.oeg.lab.data.ChartItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cbadenes on 06/11/15.
 */
public class ChartsHelperTest {

    @Test
    public void boxplot(){


        List<String> refs = Arrays.asList(new String[]{"sample1","sample2"});
        List<ChartItem> items = new ArrayList<>();
        items.add(BoxplotItemBuilder.build("doc1","s1",14l));
        items.add(BoxplotItemBuilder.build("doc2","s1",10l));
        items.add(BoxplotItemBuilder.build("doc3","s1",24l));
        items.add(BoxplotItemBuilder.build("doc4","s1",34l));
        ChartsHelper.newBoxPlot("sample1", items, refs);

        items.add(BoxplotItemBuilder.build("doc5","s1",134l));
        items.add(BoxplotItemBuilder.build("doc6","s1",234l));
        ChartsHelper.newBoxPlot("sample2", items, refs);
    }
}
