package es.upm.oeg.lab.analyzers;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.lab.harvester.ROBuilder;
import es.upm.oeg.lab.harvester.Scope;
import es.upm.oeg.lab.utils.FileHelper;
import es.upm.oeg.lab.utils.ResultHelper;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 29/10/15.
 */
public class DocumentWordsAnalyzer {

    private static final String INPUT_DIRECTORY     = "acm-siggraph-2006-2014-upf-ros";


    public static void main(String[] args) throws IOException {


        ResultHelper resultHelper   = new ResultHelper("document.words");

        List<String> header = Arrays.asList(new String[]{"doc",
                Scope.FULL.id,
                Scope.ABSTRACT.id,
                Scope.CSUMMARY.id,
                Scope.TSUMMARY.id,
                Scope.OUTCOME.id,
                Scope.FUTURE.id,
                Scope.APPROACH.id,
                Scope.BACKGROUND.id,
                Scope.CHALLENGE.id,
                Scope.TERMS.id,
                Scope.INTRODUCTION.id,
                Scope.CONCLUSION.id
        });
        resultHelper.add(header);

        Map<String,Map<String,String>> counter = new HashMap<>();


        for (Path path: FileHelper.list(INPUT_DIRECTORY, "*")){
            System.out.println("Reading: " + path);

            ResearchObject ro   = ROBuilder.fromJson(path.toFile());
            String document     = ro.getUri();
            Map map             = counter.getOrDefault(document, new HashMap<>());


            String scope        = StringUtils.substringAfterLast(path.getFileName().toString(), ".");
            long numLemmas      = ro.getBagOfWords().stream().distinct().count();

            map.put("doc",document);
            map.put(scope,String.valueOf(numLemmas));
            counter.put(document,map);
        }

        for (String doc: counter.keySet()){
            System.out.println("Writing: " + doc);
            Map<String, String> count = counter.get(doc);
            List<String> result = header.stream().
                    map(s -> count.getOrDefault(s, "")).
                    collect(Collectors.toList());

            resultHelper.add(result);
        }

        resultHelper.finish();

    }
}
