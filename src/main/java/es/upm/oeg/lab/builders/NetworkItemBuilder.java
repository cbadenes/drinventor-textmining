package es.upm.oeg.lab.builders;

import es.upm.oeg.lab.data.EdgeItem;
import es.upm.oeg.lab.data.NodeItem;

/**
 * Created by cbadenes on 11/11/15.
 */
public class NetworkItemBuilder {

    public static EdgeItem newEdge(String source, String target, Double weight){
        EdgeItem item = new EdgeItem();
        item.setSource(source);
        item.setTarget(target);
        item.setWeight(weight);
        return item;
    }

    public static NodeItem newNode(String name, Integer weight){
        NodeItem item = new NodeItem();
        item.setName(name);
        item.setSize(weight);
        return item;
    }

}
