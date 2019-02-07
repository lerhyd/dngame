package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.ActionPlace;

public class ActionPlaceInfo {

    public int id;
    public String place;

    private ActionPlaceInfo(){}

    public ActionPlaceInfo(ActionPlace dp){
        id = dp.getId();
        place = dp.getPlace();
    }
}
