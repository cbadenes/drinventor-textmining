package es.upm.oeg.lab.utils;

import edu.upf.taln.dri.lib.model.ext.Section;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by cbadenes on 27/10/15.
 */
public class SectionHelper {

    private static final Logger logger = LoggerFactory.getLogger(SectionHelper.class);

    private static final Pattern text_pattern       = Pattern.compile("[a-zA-Z -]+");
    private static final Pattern level_pattern      = Pattern.compile("\\d[.0-9]*");
    private static final Pattern root_level_pattern = Pattern.compile("^\\d [a-zA-Z ]*");

    private final List<Section> sections;

    private Map<String,Section> levels;

    public SectionHelper(List<Section> sections){
        this.sections   = sections;
        this.levels     = new HashMap<>();

        sections.stream().
                filter(s -> isHierarchicalSection(s)).
                forEach(s -> levels.put(levelOf(s), s));
    }


    public boolean isIntroduction(Section section){
        return isValid(section, Arrays.asList(new String[]{"introduction", "related work", "previous work", "background"}));
    }

    public boolean isConclusion(Section section){
        return isValid(section, Arrays.asList(new String[]{"results","conclusion", "future work"}));
    }

    public boolean isHierarchicalSection(Section section){
        return level_pattern.matcher(section.getName()).find();
    }

    public String levelOf(Section section){
        Matcher matcher = level_pattern.matcher(section.getName());
        return (!matcher.find())? "" : matcher.group();

    }

    private boolean isValid(Section section, List<String> expressions ){

        if (section == null) return false;
        return (!match(section.getName(),expressions))? isValid(parentOf(section),expressions):true;
    }

    protected static boolean match(String sectionName, List<String> expressions){
        Matcher matcher = text_pattern.matcher(sectionName);
        if (matcher.find()){
            String token = matcher.group().toLowerCase();
            return expressions.stream().filter(e -> token.contains(e)).collect(Collectors.toList()).size() > 0;
        }
        return false;
    }


    private Section parentOf(Section section){

        String currentLevel = levelOf(section);
        if (!currentLevel.contains(".")) return null; // root level
        return levels.getOrDefault(StringUtils.substringBeforeLast(currentLevel, "."), null);
    }
}
