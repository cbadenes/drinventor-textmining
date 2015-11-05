package es.upm.oeg.lab.builders;

import es.upm.oeg.lab.data.WordDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cbadenes on 03/11/15.
 */
public class RankDistanceBuilder {

    private static final Logger logger = LoggerFactory.getLogger(RankDistanceBuilder.class);

    public static double distance(WordDistribution a, WordDistribution b){

        if (a.getWords().size() != b.getWords().size()) throw new IllegalArgumentException("Different size of distributions. a=" + a + " and b=" + b);

        return vertexRanking(a,b);
    }


    public static double kendallDistance(int[] a, int[] b){
        long sum = 0;
        long size = a.length;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if ((a[i] < a[j]) && (b[i] < b[j])) {
                    sum ++;
                }
            }
        }
        double distance = 4 * sum / (double) (size * (size - 1)) - 1;
        logger.info("Kendall Tau distance between "+ Arrays.toString(a) + " and " + Arrays.toString(b) + " is: " + distance);
        return distance;
    }

    public static double spearmanDistance(int[] a, int[] b) {

        // computes Spearman's rho
        long sum = 0;
        long size = a.length;
        for(int i=0; i<size; i++) {
            long diff = a[i] - b[i];
            sum += diff * diff;
        }
        double distance = 1 - 6 * sum / (double) (size * (size * size - 1));
        logger.info("Spearman distance between "+ Arrays.toString(a) + " and " + Arrays.toString(b) + " is: " + distance);
        return distance;
    }

    public static double distancesDistance(int[] a, int[] b) {

        // computes the distances coefficient, which may be a new measure of correlation.
        // it is based on computing the relative positions of all items in the two perms
        // and summing the absolute values of the differences.

        long sum = 0;
        long size = a.length;
        for(int i=0; i<size; i++) {
            for(int j=i; j<size; j++) {
                long temp = Math.abs((a[i] - a[j]) - (b[i] - b[j]));
                sum += temp * temp;
            }
        }

        long s2 = size * size;
        long s3 = s2 * size;
        long sm1 = size - 1;
        long sm12 = sm1 * sm1;
        long sm13 = sm12 * sm1;
        long maxD = 2 * (size * (2 * sm13 + 3 * sm12 + sm1) / 6 + s2 * sm12 / 4);
        double distance = 1 - 4 * sum / (double) maxD;
        logger.info("distancesDistance between "+ Arrays.toString(a) + " and " + Arrays.toString(b) + " is: " + distance);
        return distance;
    }

    public static double distances2Distance(int[] a, int[] b) {

        // computes the distances coefficient, which may be a new measure of correlation.
        // it is based on computing the relative positions of all items in the two perms
        // and summing the absolute values of the differences.
        // if the difference represents a reversal, the difference is squared.

        long sum = 0;
        long size = a.length;

        for(int i=0; i<size; i++) {
            for(int j=i; j<size; j++) {
                long diff1 = a[i] - a[j];
                long diff2 = b[i] - b[j];
                long temp = 0;

                if (diff1 * diff2 > 0) {
                    // both have same sign
                    temp = Math.abs(diff1 - diff2);
                }
                else {
                    temp = Math.abs(diff1 - diff2) * Math.abs(diff1 - diff2);
                }

                sum += temp;
            }
        }

        sum /= 2 * (size - 1);

        long x = size - 1;
        long x2 = x * x;
        long x3 = x2 * x;
        long maxDistance = 4 * (size * (2 * x3 + 3 * x2 + x) / 6 - x * x * size * size / 4) / (2 * x);

        double distance = 1 - 2 * sum / (double) maxDistance;

        logger.info("distances2Distance between "+ Arrays.toString(a) + " and " + Arrays.toString(b) + " is: " + distance);

        return distance;
    }

    /****************************************************************************
     * Based on Graph Similarity Algorithms
     ****************************************************************************/


    /**
     * Counts the number of some operations to transform one listByExtension to the other
     * @return
     */
    public static double editDistance(int[]a, int[]b){
        double intersection = 0;
        double union = 0;
        for (int  i = 0; i < a.length; i++){
            if (a[i] == b[i]){
                intersection++;
            }
            union+=2;
        }

        double similarity = (2 * intersection) / union;

        logger.info("EditDistance between "+ Arrays.toString(a) + " and " + Arrays.toString(b) + " is: " + similarity);

        return similarity;

    }


    public static double vertexRanking(int[] a, int[] b){
        IntStream union = IntStream.concat(Arrays.stream(a), Arrays.stream(b));


        List<Integer> al = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> bl = Arrays.stream(b).boxed().collect(Collectors.toList());

        
        double D = IntStream.range(1, a.length + 1).mapToDouble(i -> Math.pow(i, 2) * 2).reduce((i, j) -> i + j).getAsDouble() * 2;

        double W = 1.0;

        double sum = union.mapToDouble(i -> W * Math.pow((vertexRankingPos(i,al) - vertexRankingPos(i,bl)), 2)).reduce((i, j) -> i + j).getAsDouble();


        double similarity = 1 - ((2 * sum) / D);

        logger.info("VertexRanking between "+ Arrays.toString(a) + " and " + Arrays.toString(b) + " is: " + similarity);

        return similarity;
    }

    private static double vertexRankingPos(int e, List<Integer> l){

        int pos = l.indexOf(e) + 1;
        if (pos == 0) return l.size()+1;
        return pos;
    }

    public static double vertexRanking(WordDistribution a, WordDistribution b){

        List<Tuple2<String, Double>> aw = a.getWords();
        List<Tuple2<String, Double>> bw = b.getWords();

        double D = IntStream.range(1, aw.size() + 1).mapToDouble(i -> Math.pow(i, 2) * 2).reduce((i, j) -> i + j).getAsDouble() * 2;

        double W = 1.0;

        Stream<Tuple2<String, Double>> union = Stream.concat(aw.stream(), bw.stream());

        double sum = union.mapToDouble(i -> vertexRankingWeight(i._1(),a,b) * Math.pow((vertexRankingPos(i._1(),a) - vertexRankingPos(i._1(),b)), 2)).reduce((i, j) -> i + j).getAsDouble();


        double similarity = 1 - ((2 * sum) / D);

        logger.info("VertexRanking between "+ a + " and " + b + " is: " + similarity);

        return similarity;
    }

    private static double vertexRankingPos(String w, WordDistribution d){

        int pos = d.getWords().stream().map(t -> t._1()).collect(Collectors.toList()).indexOf(w) + 1;
        if (pos == 0) return d.getWords().size()+1;
        return pos;
    }

    private static double vertexRankingWeight(String w, WordDistribution a, WordDistribution b){

        Optional<Double> weightA = a.getWords().stream().filter(t -> t._1().equalsIgnoreCase(w)).map(t -> t._2()).findFirst();
        Optional<Double> weightB = b.getWords().stream().filter(t -> t._1().equalsIgnoreCase(w)).map(t -> t._2()).findFirst();

        double accA = weightA.isPresent() ? weightA.get() : weightB.get();
        double accB = weightB.isPresent() ? weightB.get() : weightA.get();

        return accA + accB / 2;
    }


    public static void main(String[] args){

        WordDistribution wd1 = new WordDistribution();
        wd1.setId("1");
        wd1.add("a",0.8);
        wd1.add("b",0.4);
        wd1.add("c",0.9);

        WordDistribution wd2 = new WordDistribution();
        wd2.setId("2");
        wd2.add("e",0.7);
        wd2.add("f",0.4);
        wd2.add("c",0.9);

        System.out.println(vertexRanking(wd1, wd2));

    }

}

