package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Agent;

public class AgentInfo {
    public int id;
    public int lvl;
    public int points;
    public int numberOfCaughtKillers;
    public int numberOfWins;
    public int numberOfLoses;
    public String rank;
    public String city;
    public String country;
    public String continent;

    private AgentInfo(){}

    public AgentInfo(Agent agent){
        id = agent.getId();
        lvl = agent.getLvl();
        numberOfCaughtKillers = agent.getPoints();
        numberOfWins = agent.getNumberOfCaughtKillers();
        numberOfLoses = agent.getNumberOfWins();
        numberOfLoses = agent.getNumberOfLoses();
        rank = agent.getRank().getRank();
        city = agent.getRegion().getCity();
        country = agent.getRegion().getCountry();
        continent = agent.getRegion().getContinent();
    }
}
