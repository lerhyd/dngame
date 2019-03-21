package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import com.lerhyd.dngame.model.Region;

public class NewsInfo {

    public int id;
    public String pubDate;
    public String victimName;
    public String victimSurname;
    public String victimPatr;
    public boolean victimSex;
    public String actionDesc;
    public String actionPlace;

    public String commonCity;
    public String commonCountry;
    public String commonContinent;

    public boolean isGuiltyPersonExists;
    public String guiltyPersonName;
    public String guiltyPersonSername;
    public String guiltyPersonPatr;
    public boolean guiltyPersonSex;

    public String description;

    private NewsInfo(){}

    public NewsInfo(News news){
        id = news.getId();
        pubDate = news.getPublicationDate().toString();
        description = news.getDescription();
        actionDesc = news.getAction().getDescription();
        actionPlace = news.getActionPlace().getPlace();

        Region commonRegion = news.getCommonRegion();
        if (commonRegion!= null){
            commonCity = commonRegion.getCity();
            commonCountry = commonRegion.getCountry();
            commonContinent = commonRegion.getContinent();
        }

        Person victim = news.getVictim();
        if (victim !=null){
            victimName = victim.getName();
            victimSurname = victim.getSurname();
            victimPatr = victim.getPatronymic();
            victimSex = victim.getSex();
        }


        Person guiltyPerson = news.getGuiltyPerson();
        isGuiltyPersonExists = news.isGuiltyPersonExists();
        if (guiltyPerson != null){
            guiltyPersonName = guiltyPerson.getName();
            guiltyPersonSername = guiltyPerson.getSurname();
            guiltyPersonPatr = guiltyPerson.getPatronymic();
            guiltyPersonSex = guiltyPerson.getSex();
        }
    }

}
