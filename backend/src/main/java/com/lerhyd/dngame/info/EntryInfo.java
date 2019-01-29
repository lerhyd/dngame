package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.*;

public class EntryInfo {

    public long id;
    public int pageNum;
    public String deathDataTime;
    public String deathReason;
    public String deathPlace;
    public String desc;
    public String deathCity;
    public String deathCountry;
    public String victimName;
    public String victimSurname;
    public String victimPatr;
    public boolean victimSex;
    public String victimBornDate;

    private EntryInfo(){}

    public EntryInfo(Entry entry){
        id = entry.getId();
        pageNum = entry.getPageNumber();
        deathDataTime = entry.getDeathDataTime().toString();
        deathReason = entry.getDeathReason().getReason();
        deathPlace = entry.getDeathPlace().getPlace();
        desc = entry.getDescription();
        Region deathRegion = entry.getDeathRegion();
        deathCity = deathRegion.getCity();
        deathCountry = deathRegion.getCountry();
        Person victim = entry.getVictim();
        victimName = victim.getName();
        victimSurname = victim.getSurname();
        victimPatr = victim.getPatronymic();
        victimSex = victim.getSex();
        victimBornDate = victim.getBornDate().toLocalDate().toString();
    }
}
