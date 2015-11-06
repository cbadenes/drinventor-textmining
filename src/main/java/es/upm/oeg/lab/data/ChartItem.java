package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cbadenes on 06/11/15.
 */
@Data
public class ChartItem implements Serializable {
    private String section;
    private String file;
    private Long value;
}
