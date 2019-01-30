package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.NoteRule;

public class RulesInfo {

    public long id;
    public String desc;
    public boolean isDefault;

    private RulesInfo(){}

    public RulesInfo(NoteRule rule){
        id = rule.getId();
        desc = rule.getDescription();
        isDefault = rule.isDefault();
    }
}
