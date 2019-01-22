package com.lerhyd.dngame.service;

import com.lerhyd.dngame.model.Kira;

public interface KiraService {

    Integer getPoints(Long kiraId);
    void setRegion(Long kiraId, String country, String city);
    Kira getKira(Long kira);
}
