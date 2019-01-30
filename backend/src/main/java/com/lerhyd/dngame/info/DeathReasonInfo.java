package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.DeathReason;

public class DeathReasonInfo {

    public long id;
    public String reason;

    private DeathReasonInfo(){}

    public DeathReasonInfo(DeathReason dr){
        id = dr.getId();
        reason = dr.getReason();
    }
}
