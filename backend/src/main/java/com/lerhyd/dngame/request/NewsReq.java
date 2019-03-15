package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class NewsReq {

    private boolean die;
    private String desc;
    private String pubDate;
    private int actionId;
    private int actionPlaceId;
    private int commonRegionId;
    private int distRegionId;
    private int agentId;
    private int kiraId;
    private int victimId;
    private int guiltyPersonId;

}
