package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Kira;

public class KiraInfo {
    public int id;
    public int lvl;
    public int points;
    public int numberOfRightKills;
    public int numberOfWins;
    public int numberOfLoses;
    public String rank;
    public String city;
    public String country;
    public String continent;

    private KiraInfo(){}

    public KiraInfo(Kira kira){
        id = kira.getId();
        lvl = kira.getLvl();
        points = kira.getPoints();
        numberOfRightKills = kira.getNumberOfKills();
        numberOfWins = kira.getNumberOfWins();
        numberOfLoses = kira.getNumberOfLoses();
        rank = kira.getRank().getRank();
        city = kira.getRegion().getCity();
        country = kira.getRegion().getCountry();
        continent = kira.getRegion().getContinent();
    }
}
