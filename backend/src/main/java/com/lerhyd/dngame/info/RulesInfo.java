package com.lerhyd.dngame.info;
import com.lerhyd.dngame.model.Rule;

public class RulesInfo {

    public int id;
    public String desc;
    public boolean isDefault;

    private RulesInfo(){}

    public RulesInfo(Rule rule){
        id = rule.getId();
        desc = rule.getDescription();
        isDefault = rule.isDef();
    }
}
