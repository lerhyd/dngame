package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class RequestReq {

    private int agentId;
    private int pageNum;
    private String personName;
    private String personSername;
    private String personPatr;
    private boolean personSex;
    private int regionId;

}
