package es.upm.oeg.lab.comparators;

import es.upm.oeg.lab.data.Paper;
import es.upm.oeg.lab.data.upf.AnnotatedDoc;
import org.apache.commons.lang.StringUtils;

/**
 * Created by cbadenes on 02/11/15.
 */
public class ItemComparator {

    public static boolean sameFile(Paper p, AnnotatedDoc d){
        String a = StringUtils.substringBefore(p.getFilename(),".pdf");
        String b = d.getFileNameWithoutExt();

        return a.trim().equalsIgnoreCase(b.trim());
    }

    public static boolean same(String p, String d){
        String a = p.trim();
        String b = d.trim();

        return a.equalsIgnoreCase(b);
    }
}
