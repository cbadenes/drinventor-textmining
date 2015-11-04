package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cbadenes on 02/11/15.
 */
@Data
public class Paper implements Serializable {

    String title;

    String authors;

    String article;

    String filename;

    String doi;

    String domain;

}
