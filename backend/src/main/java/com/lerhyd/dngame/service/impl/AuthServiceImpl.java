package com.lerhyd.dngame.service.impl;

import com.lerhyd.dngame.dao.UserDao;
import com.lerhyd.dngame.model.User;
import com.lerhyd.dngame.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserDao userDao;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> signIn(int vkId) {
        return userDao.findUserByVkId(vkId);
    }

    @Override
    public Optional<User> signIn(String email) {
        return userDao.findUserByEmail(email);
    }
}
