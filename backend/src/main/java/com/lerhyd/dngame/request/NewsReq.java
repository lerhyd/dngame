package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class NewsReq {

    private String userLogin;
    private String desc;
    private String pubDate;
    private int actionId;
    private int actionPlaceId;
    private int commonRegionId;
    private int distRegionId;
    private int victimId;
    private int guiltyPersonId;

}
