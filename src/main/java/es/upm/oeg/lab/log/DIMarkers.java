package es.upm.oeg.lab.log;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Created by cbadenes on 05/11/15.
 */
public class DIMarkers {

    public static final Marker corpus       = MarkerFactory.getMarker("CORPUS");

    public static final Marker categories   = MarkerFactory.getMarker("CATEGORIES");

    public static final Marker stats        = MarkerFactory.getMarker("STATS");

    public static final Marker eval         = MarkerFactory.getMarker("EVAL");

    public static final Marker sim          = MarkerFactory.getMarker("SIM");

    public static final Marker w2v_model    = MarkerFactory.getMarker("W2V");

    public static final Marker topic_model  = MarkerFactory.getMarker("TOPICS");
}
