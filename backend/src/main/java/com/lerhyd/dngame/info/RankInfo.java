package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Rank;

public class RankInfo {

    public long id;
    public int level;
    public String rankDesc;

    private RankInfo(){}

    public RankInfo(Rank rank){
        id = rank.getId();
        level = rank.getLvl();
        rankDesc = rank.getRank();
    }
}
