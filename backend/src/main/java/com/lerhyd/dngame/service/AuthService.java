package com.lerhyd.dngame.service;

import com.lerhyd.dngame.model.User;

import java.util.Optional;

public interface AuthService {
    public Optional<User> signIn(int vkId);
    public Optional<User> signIn(String email);
}
