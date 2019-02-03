package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class NewsReq {

    private String desc;
    private String pubDate;
    private long actionId;
    private long actionPlaceId;
    private long commonRegionId;
    private long distRegionId;
    private long agentId;
    private long kiraId;
    private long victimId;
    private long fakeVictimId;
    private long killerId;

}
