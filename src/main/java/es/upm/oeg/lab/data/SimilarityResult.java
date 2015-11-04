package es.upm.oeg.lab.data;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by cbadenes on 03/11/15.
 */
@Data
public class SimilarityResult implements Serializable{

    private final Item item;
    private final Map<String, Double> similarities;
    private final Section.Type section;
    private final String mostSimilar;

    public SimilarityResult(Section.Type section, Item item, Map<String,Double> similarities){
        this.section = section;
        this.item = item;
        this.similarities = similarities;
        this.mostSimilar = calculateMostSimilar();
    }

    private String calculateMostSimilar(){
        String refCategory  = "";
        Double refValue     = Double.MIN_VALUE;
        for (String category: similarities.keySet()){
            Double value = similarities.get(category);
            if (value > refValue){
                refValue = value;
                refCategory = category;
            }
        }
        return refCategory;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();

        description.append("Distribution of Item: '").
                append(item.getRefPaper().getFilename()).
                append("' associated to category: '").
                append(item.getRefPaper().getDomain()).
                append("' in section: '").
                append(section.id).
                append("' according to the following similarities: ");
        for (String category: similarities.keySet()){
            description.append("['").append(category).append("'|").append(similarities.get(category)).append("] ");
        }
        return description.toString();
    }
}
