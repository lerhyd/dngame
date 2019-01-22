package com.lerhyd.dngame.service;

import com.lerhyd.dngame.model.User;

import java.util.List;

public interface UserService {
    public void saveUserWithoutBCrypt(User user);
    public void saveUser(User user);
    public User getUser(String login);
    public void removeUser(String login);
    public List<User> getAllUsers();
    public boolean exists(String login);


}
