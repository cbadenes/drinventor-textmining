package es.upm.oeg.lab.analyzers;

import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.lab.builders.CorpusBuilder;
import es.upm.oeg.lab.builders.ROBuilder;
import es.upm.oeg.lab.data.Paper;
import es.upm.oeg.lab.helpers.FileHelper;
import es.upm.oeg.lab.helpers.ResultHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cbadenes on 29/10/15.
 */
public class DomainAnalyzer extends ROAnalyzer {

    Logger logger = LoggerFactory.getLogger(DomainAnalyzer.class);

    public void analyze() throws IOException {

    }


    public static void main(String[] args) throws IOException {

        DomainAnalyzer analyzer = new DomainAnalyzer();

        analyzer.analyze();


    }
}
