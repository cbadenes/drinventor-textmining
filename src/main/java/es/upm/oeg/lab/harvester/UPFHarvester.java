package es.upm.oeg.lab.harvester;

import es.upm.oeg.lab.harvester.upf.AnnotatedDoc;
import es.upm.oeg.lab.harvester.upf.Criteria;
import es.upm.oeg.lab.utils.FileHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 26/10/15.
 *
 * Create text files from Annotated SIGGraph Files by content-levels, i.e. whole content, only abstract..
 *
 */
public class UPFHarvester {

    private static final Logger logger          = LoggerFactory.getLogger(UPFHarvester.class);

    private final FileHelper fileHelper         = new FileHelper();

    private final String baseDir;

    private List<AnnotatedDoc> documents;

    public UPFHarvester(String directory){
        logger.info("Loading corpus from: " + directory);
        try {
            this.baseDir            = directory;
            this.documents          = new ArrayList<>();
            documents.addAll(fileHelper.list(baseDir, "xml").stream().map(AnnotatedDoc::new).collect(Collectors.toList()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AnnotatedDoc> getDocuments(){
        return this.documents;
    }

    public void buildROs(String to, Criteria by, Boolean flat){
        try {

            for(AnnotatedDoc doc: documents){

                Path outPath;
                if (!flat){
                    outPath  = Paths.get(to, doc.getPath().getParent().getFileName().toString(),doc.getPath().getFileName().toString());
                }else{
                    outPath  = Paths.get(to, doc.getPath().getParent().getFileName().toString()+"-"+doc.getPath().getFileName().toString());
                }
                if (!outPath.getParent().toFile().exists()) outPath.getParent().toFile().mkdirs();

                // file name
                String fileName = outPath.getFileName().toString();

                // Creation of Research Object
                ROBuilder roBuilder = new ROBuilder().
                        addUrl(doc.getPath().toString()).
                        addUri(fileName).
                        addSource("SIGGRAPH").
                        addTitle(doc.getTitle()).
                        addDate(doc.getYear()).
                        addFormat("pdf").
                        addLanguage("en").
                        addRights("GPLv2").
                        addDescription("");

                // Adding authors to RO
                doc.getAuthors().stream().forEach(a -> roBuilder.addAuthor(a.getFirstName(),a.getSurname()));


                if (by.isFullText()){
                    fileHelper.write(outPath, Scope.FULL.id, roBuilder.build(doc.getFullText()));
                }

                if (by.isAbstracts()){
                    fileHelper.write(outPath, Scope.ABSTRACT.id, roBuilder.build(doc.getAbstract()));
                }

                if (by.isCentroidSummary()){
                    fileHelper.write(outPath, Scope.CSUMMARY.id, roBuilder.build(doc.getSummaryByCentroid(50)));
                }

                if (by.isTitleSummary()){
                    fileHelper.write(outPath, Scope.TSUMMARY.id, roBuilder.build(doc.getSummaryByTitle(50)));
                }

                if (by.isOutcome()){
                    fileHelper.write(outPath, Scope.OUTCOME.id, roBuilder.build(doc.getOutcome()));
                }

                if (by.isFutureWork()){
                    fileHelper.write(outPath, Scope.FUTURE.id, roBuilder.build(doc.getFutureWork()));
                }

                if (by.isApproach()){
                    fileHelper.write(outPath, Scope.APPROACH.id, roBuilder.build(doc.getApproach()));
                }

                if (by.isBackground()){
                    fileHelper.write(outPath, Scope.BACKGROUND.id, roBuilder.build(doc.getBackground()));
                }

                if (by.isChallenge()){
                    fileHelper.write(outPath, Scope.CHALLENGE.id, roBuilder.build(doc.getChallenge()));
                }

                if (by.isTerms()){
                    fileHelper.write(outPath, Scope.TERMS.id, roBuilder.build(doc.getTerms()));
                }

                if (by.isIntroduction()){
                    fileHelper.write(outPath, Scope.INTRODUCTION.id, roBuilder.build(doc.getIntroduction()));
                }

                if (by.isConclusion()){
                    fileHelper.write(outPath, Scope.CONCLUSION.id, roBuilder.build(doc.getConclusion()));
                }
            }

        } catch (RuntimeException | IOException  e) {
            logger.error("Error reading directory", e);
        }

    }





    public static void main (String[] args){

        String from = "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf";

        UPFHarvester harvester = new UPFHarvester(from);

        Criteria by = Criteria.builder().
                fullText(true).
                abstracts(true).
                centroidSummary(true).
                titleSummary(true).
                outcome(true).
                futureWork(true).
                approach(true).
                background(true).
                challenge(true).
                terms(true).
                introduction(true).
                conclusion(true).
                build();

        String to           = "acm-siggraph-2006-2014-upf-ros";
        boolean flatMode    = true;
        harvester.buildROs(to, by, flatMode);
    }


}
