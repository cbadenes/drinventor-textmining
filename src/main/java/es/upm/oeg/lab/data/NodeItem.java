package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cbadenes on 11/11/15.
 */
@Data
public class NodeItem implements Serializable{

    String name;

    Integer size;
}

