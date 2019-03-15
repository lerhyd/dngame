package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.User;

public class UserInfo {
    public String login;
    public String regDate;

    private UserInfo(){}

    public UserInfo(User user){
        login = user.getLogin();
        regDate = user.getRegistrationDate().toLocalDate().toString();
    }
}
