package es.upm.oeg.lab.builders;

import es.upm.oeg.lab.data.ModeledItem;
import es.upm.oeg.lab.data.WordDistribution;

import java.util.List;

/**
 * Created by cbadenes on 07/11/15.
 */
public class ModeledItemBuilder {

    public static ModeledItem build(String id, String label, String category, WordDistribution wd, List<WordDistribution> topics){
        ModeledItem item = new ModeledItem();
        item.setId(id);
        item.setLabel(label);
        item.setCategory(category);
        item.setWordDistribution(wd);

        // Calculate similarity to topics
        if (wd.isEmpty()) item.setTopicDistribution(new double[]{});
        else{
            double[] distribution = new double[topics.size()];
            for (int i = 0; i < distribution.length ; i++){
                distribution[i] = RankDistanceBuilder.distance(wd,topics.get(i));
            }
            item.setTopicDistribution(DirichletBuilder.normalize(distribution));
        }
        return item;
    }

    public static ModeledItem build(String id, String label, String category, double[] topicDistribution){
        ModeledItem item = new ModeledItem();
        item.setId(id);
        item.setLabel(label);
        item.setCategory(category);
        item.setTopicDistribution(topicDistribution);
        return item;
    }
}
