package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Achievement;

public class AchievementInfo {

    public String title;
    public String task;
    public String desc;

    private AchievementInfo(){}

    public AchievementInfo(Achievement ach){
        title = ach.getTitle();
        task = ach.getTask();
        desc = ach.getDescription();
    }
}
