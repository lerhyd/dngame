package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import com.lerhyd.dngame.model.Region;

public class NewsInfo {

    public long id;
    public String pubDate;
    public String victimName;
    public String victimSername;
    public String victimPatr;
    public boolean victimSex;
    public String actionDesc;
    public String actionPlace;

    public String commonCity;
    public String commonCountry;
    public String commonContinent;

    public String distCity;
    public String distCountry;
    public String distContinent;

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


        Region distRegion = news.getDistributionRegion();
        if (distRegion != null){
            distCity = distRegion.getCity();
            distCountry = distRegion.getCountry();
            distContinent = distRegion.getContinent();
        }


        Region commonRegion = news.getCommonRegion();
        if (commonRegion!= null){
            commonCity = commonRegion.getCity();
            commonCountry = commonRegion.getCountry();
            commonContinent = commonRegion.getContinent();
        }

        Person victim = news.getVictim();
        if (victim !=null){
            victimName = victim.getName();
            victimSername = victim.getSurname();
            victimPatr = victim.getPatronymic();
            victimSex = victim.getSex();
        }


        Person guiltyPerson = news.getGuiltyPerson();
        if (guiltyPerson != null){
            guiltyPersonName = guiltyPerson.getName();
            guiltyPersonSername = guiltyPerson.getSurname();
            guiltyPersonPatr = guiltyPerson.getPatronymic();
            guiltyPersonSex = guiltyPerson.getSex();
        }
    }

}
