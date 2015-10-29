package es.upm.oeg.lab.harvester;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import es.upm.oeg.epnoi.harvester.domain.Creator;
import es.upm.oeg.epnoi.harvester.domain.MetaInformation;
import es.upm.oeg.epnoi.harvester.domain.ResearchObject;
import es.upm.oeg.epnoi.harvester.domain.ResearchSource;
import es.upm.oeg.lab.utils.StanfordNLPHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbadenes on 26/10/15.
 */
public class ROBuilder {

    private static final String DRI_URI = "http://drinventor/";

    private static final StanfordNLPHelper nlpHelper = new StanfordNLPHelper();

    private List<Creator> authors;

    private ResearchSource source;

    private String uri;
    private String url;
    private String title;
    private String date;
    private String format;
    private String language;
    private String rights;
    private String description;

    public ROBuilder(){
        this.authors        = new ArrayList<>();
        this.uri            = "";
        this.url            = "";
        this.title          = "";
        this.date           = "";
        this.format         = "pdf";
        this.language       = "en";
        this.rights         = "GPLv2";
        this.description    = "";
    }

    public ROBuilder addUri(String uri){
        this.uri = uri;
        return this;
    }

    public ROBuilder addUrl(String url){
        this.url = url;
        return this;
    }

    public ROBuilder addSource(String name){
        this.source = new ResearchSource();
        this.source.setName(name);
        this.source.setUri(DRI_URI+name);
        this.source.setUrl(DRI_URI+name);
        this.source.setProtocol("http");
        return this;
    }

    public ROBuilder addTitle(String title){
        this.title = title;
        return this;
    }

    public ROBuilder addDate(String date){
        this.date = date;
        return this;
    }

    public ROBuilder addFormat(String format){
        this.format = format;
        return this;
    }

    public ROBuilder addLanguage(String language){
        this.language = language;
        return this;
    }

    public ROBuilder addRights(String rights){
        this.rights = rights;
        return this;
    }

    public ROBuilder addDescription(String description){
        this.description = description;
        return this;
    }

    public ROBuilder addAuthor(String name, String surname){
        Creator author = new Creator();
        author.setName(name);
        author.setSurname(surname);
        author.setUri(DRI_URI+name+"-"+surname);
        authors.add(author);
        return this;
    }

    public ResearchObject build(String content){

        ResearchObject ro = new ResearchObject();
        ro.setUri(this.uri);
        ro.setUrl(this.url);
        ro.setSource(this.source);
        ro.setResources(new ArrayList<>());

        MetaInformation metaInformation = new MetaInformation();
        metaInformation.setCreators(authors);
        metaInformation.setDescription(this.description);
        metaInformation.setFormat(this.format);
        metaInformation.setLanguage(this.language);
        metaInformation.setPublished(this.date);
        metaInformation.setRights(this.rights);
        metaInformation.setTitle(this.title);
        ro.setMetainformation(metaInformation);

        // Content
        ro.setContent(content);

        // lemmatize content
        List<String> bagOfWords = nlpHelper.lemmatize(content);
        ro.setBagOfWords(bagOfWords);

        return ro;
    }

    public String toJson(String content){
        ObjectWriter jacksonSerializer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ResearchObject ro = build(content);
        try {
            return jacksonSerializer.writeValueAsString(ro);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResearchObject fromJson(String researchObject){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(researchObject, ResearchObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResearchObject fromJson(File json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, ResearchObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
