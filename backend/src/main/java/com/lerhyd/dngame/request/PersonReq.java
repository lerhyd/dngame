package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class PersonReq {

    private String name;
    private String surname;
    private String patr;
    private boolean sex;
    private String bornDate;
    private String userLogin;
}
