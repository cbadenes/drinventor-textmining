package es.upm.oeg.lab.builders;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by cbadenes on 05/11/15.
 */
public class JsonBuilder {

    private static final Logger logger = LoggerFactory.getLogger(JsonBuilder.class);

    private static ObjectMapper jackson = new ObjectMapper();

    public static String toJson(Object instance){
        try {
            return jackson.writeValueAsString(instance);
        } catch (IOException e) {
            logger.error("Serializing to json",e);
            return "{}";
        }
    }
}
