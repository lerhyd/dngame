package com.lerhyd.dngame.request;

import lombok.Data;

@Data
public class UserReq {

    private String login;
    private String password;
    private String retypePassword;
    private String email;
    private int vkId;
}
