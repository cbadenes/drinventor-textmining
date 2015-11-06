package es.upm.oeg.lab.builders;

import es.upm.oeg.lab.data.ChartItem;

/**
 * Created by cbadenes on 06/11/15.
 */
public class BoxplotItemBuilder {

    public static ChartItem build(String file, String section, Long value){

        ChartItem item = new ChartItem();
        item.setFile(file);
        item.setSection(section);
        item.setValue(value);
        return item;
    }
}
