package es.upm.oeg.lab.builders;

import es.upm.oeg.epnoi.harvester.domain.Creator;

/**
 * Created by cbadenes on 02/11/15.
 */
public class CreatorBuilder {

    public static Builder newInstance(){
        return new Builder();
    }

    public static class Builder{

        private String name;
        private String surname;

        public Builder addName(String name){
            this.name = name;
            return this;
        }

        public Builder addSurname(String surname){
            this.surname = surname;
            return this;
        }

        public Creator build(){
            Creator creator = new Creator();
            creator.setName(name);
            creator.setSurname(surname);
            creator.setUri("author/"+name+"-"+surname);
            return creator;
        }
    }
}
