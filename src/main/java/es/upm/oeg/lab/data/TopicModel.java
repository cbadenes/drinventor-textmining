package es.upm.oeg.lab.data;

import es.upm.oeg.epnoi.matching.metrics.domain.entity.ConceptualResource;
import es.upm.oeg.lab.builders.ROBuilder;
import org.apache.spark.mllib.linalg.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.io.Serializable;
import java.util.*;

/**
 * Created by cbadenes on 03/11/15.
 */
public class TopicModel implements Serializable{

    private static final Logger logger = LoggerFactory.getLogger(TopicModel.class);
    private String id;

    private Tuple2<int[], double[]>[] topics;
    private Map<String,Long> ids = new HashMap<>();
    private Map<Long, String> words;
    private List<Tuple2<Object, Vector>> documents;

    public TopicModel(String id, List<Tuple2<Object, Vector>> documents, Map<Object, String> words,Tuple2<int[], double[]>[] topics, List<Tuple2<Object, ConceptualResource>> resources ){

        this.id = id;
        this.words = new HashMap<>();

        for (Object key: words.keySet()){
            String word = words.get(key);
            Long wordId = (Long) key;
            this.words.put(wordId,word);
            logger.info("adding word: " + word + " with key: " + wordId);
        }

        this.topics     = topics;
        this.documents  = documents;
        this.ids        = new HashMap<>();

        for (Tuple2<Object,ConceptualResource> docDist : resources){

            Long resId                  = (Long) docDist._1();
            ConceptualResource cr       = docDist._2();
            String uri                  = cr.resource().uri();

            logger.info("Added conceptual resource: " + uri + " with Id: " + resId);
            ids.put(uri,resId);
        }
    }

    public TopicModel(){
    }

    public boolean isEmpty(){
        return topics == null;
    }

    public List<WordDistribution> getTopics(Integer numWords){

        List<WordDistribution> wds = new ArrayList<>();

        for (int i=0;i < topics.length; i++ ){

            WordDistribution wd = new WordDistribution();
            wd.setId("topic"+i);

            Tuple2<int[], double[]> distr = topics[i];

            int[] wordIds = distr._1();
            double[] weights = distr._2();

            for (int j = 0; j < numWords; j++){
                int wordId = wordIds[j];
                String word = words.get(new Long(wordId));

                logger.trace("Word: '" + word + "' [" + wordId + "/" + words.size() + "]");

                Double weight = weights[j];
                wd.add(word,weight);
            }

            wds.add(wd);
        }

        return wds;
    }


    public double[] getDistribution(Item item){

        logger.debug("Trying to get topic distribution of item: " + item);
        String uri    = ROBuilder.getUri(item);
        Long resId    = ids.get(uri);

        Optional<Tuple2<Object, Vector>> tupleOpt = documents.stream().filter(t -> t._1().equals(resId)).findFirst();

        if (!tupleOpt.isPresent()){
            logger.error("Topics distribution not found for item: " + item  + " in documents: " + documents.size());
            return new double[]{0.0};
        }
        Tuple2<Object, Vector> tuple = tupleOpt.get();
        logger.debug("Tuple: " + tuple);

        double[] dist = tuple._2().toArray();
        logger.info("Topics Distribution of '"+item.getRefPaper().getFilename()+"' in '"+id+"': " + Arrays.toString(dist));
        return dist;
    }

}
