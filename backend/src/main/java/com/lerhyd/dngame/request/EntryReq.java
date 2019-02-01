package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class EntryReq {
    private long kiraId;
    private int pageNum;
    private int actionId;
    private String victimName;
    private String victimSername;
    private String victimPatr;
    private boolean victimSex;
    private String desc;
    private String deathDate;
    private long actionPlaceId;
    private long deathRegionId;
}
