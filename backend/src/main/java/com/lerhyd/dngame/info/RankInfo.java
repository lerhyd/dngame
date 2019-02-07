package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Rank;

public class RankInfo {

    public int id;
    public int points;
    public String rankDesc;

    private RankInfo(){}

    public RankInfo(Rank rank){
        id = rank.getId();
        points = rank.getPoints();
        rankDesc = rank.getRank();
    }
}
