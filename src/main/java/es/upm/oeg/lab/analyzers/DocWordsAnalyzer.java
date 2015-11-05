package es.upm.oeg.lab.analyzers;

import java.io.IOException;

/**
 * Created by cbadenes on 29/10/15.
 */
public class DocWordsAnalyzer extends ROAnalyzer {

    public void analyze() throws IOException {
//        ResultHelper resultHelper   = new ResultHelper("document.words");
//
//        List<String> header = Arrays.asList(new String[]{"doc",
//                Section.FULL.id,
//                Section.ABSTRACT.id,
//                Section.CSUMMARY.id,
//                Section.TSUMMARY.id,
//                Section.OUTCOME.id,
//                Section.FUTURE.id,
//                Section.APPROACH.id,
//                Section.BACKGROUND.id,
//                Section.CHALLENGE.id,
//                Section.TERMS.id,
//                Section.INTRODUCTION.id,
//                Section.CONCLUSION.id
//        });
//        resultHelper.add(header);
//
//        Map<String,Map<String,String>> counter = new HashMap<>();
//
//
//        for (Path path: FileHelper.listByExtension(RO_FOLDER, "*")){
//            System.out.println("Reading: " + path);
//
//            ResearchObject ro   = ROBuilder.fromJson(path.toFile());
//            String document     = ro.getUri();
//            Map map             = counter.getOrDefault(document, new HashMap<>());
//
//
//            String scope        = StringUtils.substringAfterLast(path.getFileName().toString(), ".");
//            long numLemmas      = ro.getBagOfWords().stream().distinct().count();
//
//            map.put("doc",document);
//            map.put(scope,String.valueOf(numLemmas));
//            counter.put(document,map);
//        }
//
//        for (String doc: counter.keySet()){
//            System.out.println("Writing: " + doc);
//            Map<String, String> count = counter.get(doc);
//            List<String> result = header.stream().
//                    map(s -> count.getOrDefault(s, "")).
//                    collect(Collectors.toList());
//
//            resultHelper.add(result);
//        }
//
//        resultHelper.finish();
    }


    public static void main(String[] args) throws IOException {

        DocWordsAnalyzer analyzer = new DocWordsAnalyzer();

        analyzer.analyze();


    }
}
