package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.*;

public class EntryInfo {

    public long id;
    public int pageNum;
    public String victimName;
    public String victimSurname;
    public String victimPatr;
    public String deathReason;
    public String deathPlace;
    public String deathDataTime;
    public String deathCity;
    public String deathCountry;
    public String deathContinent;
    public String desc;
    public boolean victimSex;

    private EntryInfo(){}

    public EntryInfo(Entry entry){
        id = entry.getId();
        pageNum = entry.getPageNumber();
        deathDataTime = entry.getDeathDataTime().toString();
        deathReason = entry.getAction().getDescription();
        deathPlace = entry.getActionPlace().getPlace();
        desc = entry.getDescription();
        Region deathRegion = entry.getDeathRegion();
        deathCity = deathRegion.getCity();
        deathCountry = deathRegion.getCountry();
        deathContinent = deathRegion.getContinent();
        Person victim = entry.getVictim();
        victimName = victim.getName();
        victimSurname = victim.getSurname();
        victimPatr = victim.getPatronymic();
        victimSex = victim.getSex();
    }
}
