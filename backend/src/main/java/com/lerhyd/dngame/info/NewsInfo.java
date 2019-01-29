package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import com.lerhyd.dngame.model.Region;
import com.lerhyd.dngame.model.SupposedVictim;

public class NewsInfo {

    public long id;
    public String whatDid;
    public String publDate;
    public String actionDesc;
    public String distCity;
    public String distCountry;
    public String victimName;
    public String victimSername;
    public String victimPatr;
    public String killerName;
    public String killerSername;
    public String killerPatr;
    public boolean killerSex;
    public String killlerBornDate;
    private NewsInfo(){}
    public NewsInfo(News news){
        id = news.getId();
        whatDid = news.getWhatDid();
        publDate = news.getPublicationDateTime().toLocalDate().toString();
        actionDesc = news.getAction().getDescription();
        Region distRegion = news.getDistributionRegion();
        distCity = distRegion.getCity();
        distCountry = distRegion.getCountry();
        SupposedVictim victim = news.getSupposedVictim();
        victimName = victim.getName();
        victimSername = victim.getSurname();
        victimPatr = victim.getPatronymic();
        Person killer = news.getKiller();
        killerName = killer.getName();
        killerSername = killer.getSurname();
        killerPatr = killer.getPatronymic();
        killerSex = killer.getSex();
        killlerBornDate = killer.getBornDate().toLocalDate().toString();
    }

}
