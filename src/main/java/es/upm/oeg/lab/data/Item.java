package es.upm.oeg.lab.data;

import es.upm.oeg.epnoi.harvester.domain.Creator;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cbadenes on 11/11/15.
 */
@Data
public class Item implements Serializable{

    Paper refPaper;

    List<Creator> authors;

    String date;

    String title;

    Part part;

}
