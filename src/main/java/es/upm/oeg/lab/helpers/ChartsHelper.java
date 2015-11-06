package es.upm.oeg.lab.helpers;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbadenes on 06/11/15.
 */
public class ChartsHelper {

    private static final Logger logger = LoggerFactory.getLogger(ChartsHelper.class);

    public static final String DIRECTORY            = "charts";

    private static final String TEMPLATE_DIRECTORY  = "src/main/charts";

    private static ObjectMapper mapper = new ObjectMapper();

    private static VelocityEngine velEngine;

    static{
        velEngine = new VelocityEngine();
        velEngine.setProperty(VelocityEngine.RESOURCE_LOADER, "file");
        velEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, Paths.get(TEMPLATE_DIRECTORY).toAbsolutePath().toString());
        velEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_CACHE, "false");
        velEngine.init();
    }

    public static void newBoxPlot(String name, Object value){
        newChart("boxplot",name,value);
    }

    public static void newBar(String name, Object value){
        newChart("bar",name,value);
    }

    private static void newChart(String type,String name, Object value){
        try {

            String json = mapper.writeValueAsString(value);

            VelocityContext context = new VelocityContext();
            context.put("name",name);
            context.put("id","file");
            context.put("x","section");
            context.put("y","value");
            context.put("data",json);

            StringWriter writer = new StringWriter();
            velEngine.getTemplate(type+".html.vm", "UTF-8").merge(context,writer);


            // Write to file
            FileUtils.write(Paths.get(DIRECTORY,type+"-"+name+".html").toFile(),writer.toString(),false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
