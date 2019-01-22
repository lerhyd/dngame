package com.lerhyd.dngame.service.impl;

import com.lerhyd.dngame.dao.UserDao;
import com.lerhyd.dngame.model.User;
import com.lerhyd.dngame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveUserWithoutBCrypt(User user) {
        userDao.save(user);
    }

    @Override
    public void saveUser(User user) {
        if (user.getPassword() != null)
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User getUser(String login) {
        return userDao.findById(login).orElse(null);
    }

    @Override
    public void removeUser(String login) {
        userDao.deleteById(login);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> lst = new ArrayList<>();
        Iterator<User> iterator = userDao.findAll().iterator();
        while (iterator.hasNext()){
            lst.add(iterator.next());
        }
        return lst;
    }

    @Override
    public boolean exists(String login) {
        return userDao.existsById(login);
    }
}
