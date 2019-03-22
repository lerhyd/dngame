package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class EntryReq {
    private String userLogin;
    private int actionId;
    private String victimName;
    private String victimSurname;
    private String victimPatr;
    private boolean victimSex;
    private String desc;
    private String deathDate;
    private int actionPlaceId;
}
