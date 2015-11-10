package es.upm.oeg.lab.helpers;

import es.upm.oeg.lab.builders.ChartItemBuilder;
import es.upm.oeg.lab.data.ChartItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbadenes on 06/11/15.
 */
public class ChartsHelperTest {

    @Test
    public void boxplot(){


        List<ChartItem> items = new ArrayList<>();
        items.add(ChartItemBuilder.build("doc1", "s1", 14l));
        items.add(ChartItemBuilder.build("doc2", "s1", 10l));
        items.add(ChartItemBuilder.build("doc3", "s1", 24l));
        items.add(ChartItemBuilder.build("doc4", "s1", 34l));
        ChartsHelper.newBoxPlot("sample1","", items);

        items.add(ChartItemBuilder.build("doc5", "s1", 134l));
        items.add(ChartItemBuilder.build("doc6", "s1", 234l));
        ChartsHelper.newBoxPlot("sample2","", items);
    }

    @Test
    public void lineplot(){


        List<ChartItem> items = new ArrayList<>();
        items.add(ChartItemBuilder.build("abs", "modeling", 9l));
        items.add(ChartItemBuilder.build("abs", "3dprinting", 1l));
        items.add(ChartItemBuilder.build("abs", "rendering", 4l));
        items.add(ChartItemBuilder.build("full", "modeling", 4l));
        items.add(ChartItemBuilder.build("full", "3dprinting", 5l));
        items.add(ChartItemBuilder.build("full", "rendering", 2l));
        items.add(ChartItemBuilder.build("chl", "modeling", 3l));
        items.add(ChartItemBuilder.build("chl", "3dprinting", 7l));
        items.add(ChartItemBuilder.build("chl", "rendering", 8l));
        ChartsHelper.newLinePlot("precision","", items);

        items.add(ChartItemBuilder.build("doc5", "s1", 134l));
        items.add(ChartItemBuilder.build("doc6", "s1", 234l));
        ChartsHelper.newLinePlot("recall","", items);
    }

    @Test
    public void scatterplot(){
        List<ChartItem> items = new ArrayList<>();
        items.add(ChartItemBuilder.build("abs", "modeling", 0.45));
        items.add(ChartItemBuilder.build("abs", "3dprinting", 0.60));
        items.add(ChartItemBuilder.build("abs", "rendering", -0.2));
        items.add(ChartItemBuilder.build("full", "modeling", 0.1));
        ChartsHelper.newScatterPlot("precision","", items);
    }

    @Test
    public void pieplot(){
        List<ChartItem> items = new ArrayList<>();
        items.add(ChartItemBuilder.build("modeling", "", 20));
        items.add(ChartItemBuilder.build("3dprinting", "", 60));
        items.add(ChartItemBuilder.build("rendering", "", 20));
        ChartsHelper.newPieChart("categories","", items);
    }

    @Test
    public void bubbles(){
        List<ChartItem> items = new ArrayList<>();
        items.add(ChartItemBuilder.build("wordA", "topic0", 0.06));
        items.add(ChartItemBuilder.build("wordB", "topic0", 0.7));
        items.add(ChartItemBuilder.build("wordC", "topic0", 0.03));
        items.add(ChartItemBuilder.build("wordB", "topic1", 0.8));
        items.add(ChartItemBuilder.build("wordH", "topic1", 0.1));
        items.add(ChartItemBuilder.build("wordG", "topic1", 0.1));
        items.add(ChartItemBuilder.build("wordB", "topic2", 0.04));
        items.add(ChartItemBuilder.build("wordH", "topic2", 0.06));
        items.add(ChartItemBuilder.build("wordG", "topic2", 0.9));
        items.add(ChartItemBuilder.build("wordB", "topic3", 0.3));
        items.add(ChartItemBuilder.build("wordH", "topic3", 0.4));
        items.add(ChartItemBuilder.build("wordG", "topic3", 0.3));
        ChartsHelper.newBubbles("topics","", items);
    }

    @Test
    public void treemap(){
        List<ChartItem> items = new ArrayList<>();
        items.add(ChartItemBuilder.build("wordA", "", 0.06));
        items.add(ChartItemBuilder.build("wordB", "", 0.7));
        items.add(ChartItemBuilder.build("wordC", "", 0.03));
        items.add(ChartItemBuilder.build("wordD", "", 0.8));
        items.add(ChartItemBuilder.build("wordE", "", 0.1));
        items.add(ChartItemBuilder.build("wordF", "", 0.1));
        items.add(ChartItemBuilder.build("wordG", "", 0.04));
        items.add(ChartItemBuilder.build("wordH", "", 0.06));
        items.add(ChartItemBuilder.build("wordI", "", 0.9));
        items.add(ChartItemBuilder.build("wordJ", "", 0.3));
        items.add(ChartItemBuilder.build("wordK", "", 0.4));
        items.add(ChartItemBuilder.build("wordL", "", 0.3));
        ChartsHelper.newTreeMap("w2v-category-section", "", items);
    }


    @Test
    public void stacked(){
        List<ChartItem> items = new ArrayList<>();
        items.add(ChartItemBuilder.build("precision", "abs", 0.7));
        items.add(ChartItemBuilder.build("recall", "abs", 0.3));
        items.add(ChartItemBuilder.build("f-measure", "abs", 0.6));
        items.add(ChartItemBuilder.build("precision", "full", 0.3));
        items.add(ChartItemBuilder.build("recall", "full", 0.5));
        items.add(ChartItemBuilder.build("f-measure", "full", 0.3));
        items.add(ChartItemBuilder.build("precision", "chl", 0.2));
        items.add(ChartItemBuilder.build("recall", "chl", 0.7));
        items.add(ChartItemBuilder.build("f-measure", "chl", 0.4));
        items.add(ChartItemBuilder.build("precision", "app", 0.5));
        items.add(ChartItemBuilder.build("recall", "app", 0.3));
        items.add(ChartItemBuilder.build("f-measure", "app", 0.2));
        ChartsHelper.newStacked("category-eval", "", items);
    }

    @Test
    public void index(){
        List<ChartItem> items = new ArrayList<>();
        items.add(ChartItemBuilder.build("precision", "abs", 0.7));
        items.add(ChartItemBuilder.build("f-measure", "app", 0.2));
        ChartsHelper.newStacked("this-sample", "description 1", items);
        ChartsHelper.newTreeMap("sample3", "description 1", items);
        ChartsHelper.newTreeMap("wwww", "description 1", items);
        ChartsHelper.newTreeMap("aaaa", "description 1", items);

        ChartsHelper.report();
    }

}
