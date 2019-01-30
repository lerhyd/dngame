package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.DeathPlace;

public class DeathPlaceInfo {

    public long id;
    public String place;

    private DeathPlaceInfo(){}

    public DeathPlaceInfo(DeathPlace dp){
        id = dp.getId();
        place = dp.getPlace();
    }
}
