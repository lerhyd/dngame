package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.*;

public class EntryInfo {

    public int id;
    public int pageNum;
    public String victimName;
    public String victimSurname;
    public String victimPatr;
    public String deathReason;
    public String deathPlace;
    public String deathDataTime;
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
        Person victim = entry.getVictim();
        victimName = victim.getName();
        victimSurname = victim.getSurname();
        victimPatr = victim.getPatronymic();
        victimSex = victim.getSex();
    }
}
