package es.upm.oeg.lab.hoarder;

import es.upm.oeg.lab.upf.AnnotatedDoc;
import es.upm.oeg.lab.upf.Criteria;
import es.upm.oeg.lab.utils.FilesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
public class AnnotatedDocHoarder {

    private static final Logger logger          = LoggerFactory.getLogger(AnnotatedDocHoarder.class);

    private final String baseDir;

    private List<AnnotatedDoc> documents;

    public AnnotatedDocHoarder(String directory){
        logger.info("Loading corpus from: " + directory);
        try {
            this.baseDir        = directory;
            this.documents      = new ArrayList<>();
            documents.addAll(FilesHelper.find(baseDir, "xml").stream().map(AnnotatedDoc::new).collect(Collectors.toList()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AnnotatedDoc> getDocuments(){
        return this.documents;
    }

    public void split(String to, Criteria by, Boolean flat){
        try {
            for(AnnotatedDoc doc: documents){

                Path outPath  = null;
                if (!flat){
                    outPath  = Paths.get(to, doc.getPath().getParent().getFileName().toString(),doc.getPath().getFileName().toString());
                }else{
                    outPath  = Paths.get(to, doc.getPath().getParent().getFileName().toString()+"-"+doc.getPath().getFileName().toString());
                }
                if (!outPath.getParent().toFile().exists()) outPath.getParent().toFile().mkdirs();

                if (by.isFullText()){
                    write(outPath, "full", doc.getFullText());
                }

                if (by.isAbstracts()){
                    write(outPath, "abstract", doc.getAbstract());
                }

                if (by.isCentroidSummary()){
                    write(outPath, "csummary", doc.getSummaryByCentroid(50));
                }

                if (by.isTitleSummary()){
                    write(outPath, "tsummary", doc.getSummaryByTitle(50));
                }

                if (by.isOutcome()){
                    write(outPath, "outcome", doc.getOutcome());
                }

                if (by.isFutureWork()){
                    write(outPath, "future", doc.getFutureWork());
                }

                if (by.isApproach()){
                    write(outPath, "approach", doc.getApproach());
                }

                if (by.isBackground()){
                    write(outPath, "background", doc.getBackground());
                }

                if (by.isChallenge()){
                    write(outPath, "challenge", doc.getChallenge());
                }

                if (by.isTerms()){
                    write(outPath, "terms", doc.getTerms());
                }

                if (by.isIntroduction()){
                    write(outPath, "introduction", doc.getIntroduction());
                }

                if (by.isConclusion()){
                    write(outPath, "conclusion", doc.getConclusion());
                }
            }

        } catch (RuntimeException | IOException  e) {
            logger.error("Error reading directory", e);
        }

    }


    private void write(Path path, String suffix, String content) throws IOException {
        Path outFile = new File(path.toString()+"."+suffix).toPath();
        Files.write(outFile, content.getBytes());
        logger.info("Wrote in: " + outFile.toString());
    }


    public static void main (String[] args){

        String from = "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf";

        String to   = "acm-siggraph-2006-2014-upf-split";

        AnnotatedDocHoarder splitter = new AnnotatedDocHoarder(from);

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

        splitter.split(to,by,true);
    }


}
