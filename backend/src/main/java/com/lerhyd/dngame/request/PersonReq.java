package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class PersonReq {

    private String name;
    private String surname;
    private String patr;
    private boolean sex;
    private boolean fake;
    private boolean criminal;
    private String bornDate;
    private String deathDate;
    private String userLogin;
}
