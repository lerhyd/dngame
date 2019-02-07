package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Action;

public class ActionInfo {

    public int id;
    public String desc;

    private ActionInfo(){}

    public ActionInfo(Action act){
        id = act.getId();
        desc = act.getDescription();

    }
}
