package es.upm.oeg.lab.builders;

import es.upm.oeg.lab.data.ChartItem;

/**
 * Created by cbadenes on 06/11/15.
 */
public class ChartItemBuilder {

    public static ChartItem build(String key, String label, Number value){

        ChartItem item = new ChartItem();
        item.setKey(key);
        item.setLabel(label);
        item.setValue(value);
        return item;
    }
}
