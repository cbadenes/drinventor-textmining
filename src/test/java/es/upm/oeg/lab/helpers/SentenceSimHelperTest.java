package es.upm.oeg.lab.helpers;

import es.upm.oeg.lab.data.Sentence;
import es.upm.oeg.lab.data.Text;
import es.upm.oeg.lab.data.Token;
import opennlp.tools.parser.Parse;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by cbadenes on 20/11/15.
 */
public class SentenceSimHelperTest {


    @Test
    public void sectionTitles(){
        String[] s1 = new String[]{"Introduction"};
        String[] s2 = new String[]{"Related","Works"};

        double[][] simMatrix = WordNetSimHelper.wuPalmer(s1, s2);

        for (int  i=0; i < simMatrix.length; i++){
            double[] row = simMatrix[i];
            for(int j=0; j < row.length; j++){
                System.out.println("["+i+","+j+"] - " + simMatrix[i][j]);
            }
        }
    }

    @Test
    public void sectionTitles2() throws IOException {
        OpenNLPHelper helper = new OpenNLPHelper();
        Parse out = helper.parseLine("Results and Discussion");
        out.show();

    }

}
