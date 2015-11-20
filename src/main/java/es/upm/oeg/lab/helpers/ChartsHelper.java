package es.upm.oeg.lab.helpers;

import es.upm.oeg.lab.Analyzer;
import es.upm.oeg.lab.data.ChartItem;
import es.upm.oeg.lab.data.EdgeItem;
import es.upm.oeg.lab.data.NodeItem;
import es.upm.oeg.lab.data.Part;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 06/11/15.
 */
public class ChartsHelper {

    private static final Logger logger = LoggerFactory.getLogger(ChartsHelper.class);

    public static final String DIRECTORY            = "charts";

    private static final String TEMPLATE_DIRECTORY  = "src/main/charts";

    private static ConcurrentHashMap<String,String> charts = new ConcurrentHashMap<>();

    private static ObjectMapper mapper = new ObjectMapper();

    private static VelocityEngine velEngine;

    static{
        velEngine = new VelocityEngine();
        velEngine.setProperty(VelocityEngine.RESOURCE_LOADER, "file");
        velEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, Paths.get(TEMPLATE_DIRECTORY).toAbsolutePath().toString());
        velEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_CACHE, "false");
        velEngine.init();
    }

    public static void newBoxPlot(String name, String description,  List<ChartItem> values){
        newChart("boxplot",name,description,values);
    }

    public static void newBarPlot(String name, String description, List<ChartItem> values){
        newChart("bar",name,description,values);
    }

    public static void newLinePlot(String name, String description, List<ChartItem> values){
        newChart("line",name,description,values);
    }

    public static void newScatterPlot(String name, String description, List<ChartItem> values){
        newChart("scatter",name,description,values);
    }

    public static void newPieChart(String name, String description, List<ChartItem> values){
        newChart("pie",name,description,values);
    }

    public static void newBubbles(String name, String description, List<ChartItem> values){
        newChart("bubbles",name,description,values);
    }

    public static void newTreeMap(String name, String description, List<ChartItem> values){
        newChart("treemap",name,description,values);
    }

    public static void newStacked(String name, String description, List<ChartItem> values){
        newChart("stacked",name,description,values);
    }

    public static void newNetwork(String name, String description, List<NodeItem> nodes, List<EdgeItem> edges){
        try {
            String edgesJson = mapper.writeValueAsString(edges);
            String nodesJson = mapper.writeValueAsString(nodes);

            VelocityContext context = new VelocityContext();
            context.put("nodes",nodesJson);
            context.put("edges",edgesJson);

            StringWriter writer = new StringWriter();
            velEngine.getTemplate("network.html.vm", "UTF-8").merge(context,writer);

            // Write to file
            File file = Paths.get(DIRECTORY,name+".html").toFile();
            FileUtils.write(file,writer.toString(),false);

            // Record
            charts.put(StringUtils.substringBefore(file.getName(),".html"),description);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void newChart(String type,String name, String description, List<ChartItem> values){
        try {

            String json = mapper.writeValueAsString(values);

            VelocityContext context = new VelocityContext();
            context.put("name",name);
            context.put("id","key");
            context.put("group","label");
            context.put("x","label");
            context.put("y","value");
            context.put("value","value");
            context.put("data",json);

            StringWriter writer = new StringWriter();
            velEngine.getTemplate(type+".html.vm", "UTF-8").merge(context,writer);


            // Write to file
            File file = Paths.get(DIRECTORY,name+".html").toFile();
            FileUtils.write(file,writer.toString(),false);

            // Record
            charts.put(StringUtils.substringBefore(file.getName(),".html"),description);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void report(){
        try {
            VelocityContext context = new VelocityContext();
            context.put("references",Collections.list(charts.keys()).stream().sorted().map(k -> new AbstractMap.SimpleEntry<>(k, charts.get(k))).collect(Collectors.toList()));

            // Settings
            List settings = new ArrayList<>();
            settings.add(new AbstractMap.SimpleEntry<>("Annotated Content Directory", Analyzer.CONTENT_CORPUS));
            settings.add(new AbstractMap.SimpleEntry<>("Annotated Context Directory", Analyzer.CONTEXT_CORPUS));
            settings.add(new AbstractMap.SimpleEntry<>("Number of words used(for topics and w2v-synonyms)", String.valueOf(Analyzer.NUM_WORDS)));
            settings.add(new AbstractMap.SimpleEntry<>("Vector Dimension for W2V Model", String.valueOf(Analyzer.W2V_DIMENSION)));
            settings.add(new AbstractMap.SimpleEntry<>("Max Iterations for LDA algorithm", String.valueOf(Analyzer.LDA_MAX_ITERATIONS)));
            context.put("settings",settings);

            // Legend
            context.put("legends",Arrays.stream(Part.Type.values()).sorted().map(s -> new AbstractMap.SimpleEntry<>(s.id, s.name())).collect(Collectors.toList()));


            StringWriter writer = new StringWriter();
            velEngine.getTemplate("index.html.vm", "UTF-8").merge(context,writer);


            // Write to file
            File file = Paths.get(DIRECTORY,"index.html").toFile();
            FileUtils.write(file,writer.toString(),false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
