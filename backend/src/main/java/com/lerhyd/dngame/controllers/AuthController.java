package com.lerhyd.dngame.controllers;

import com.lerhyd.dngame.dao.RoleDao;
import com.lerhyd.dngame.dao.RuleDao;
import com.lerhyd.dngame.dao.UserDao;
import com.lerhyd.dngame.model.Role;
import com.lerhyd.dngame.model.Rule;
import com.lerhyd.dngame.model.User;
import com.lerhyd.dngame.request.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RuleDao ruleDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/registration")
    public int createUser(@RequestBody @Valid UserReq userReq, BindingResult bindingResult){
        if (userDao.existsById(userReq.getLogin()))
            return 1;
        if (bindingResult.hasErrors())
            return 2;
        Role userRole = roleDao.findById("USER").get();
        User user = new User();
        user.setLogin(userReq.getLogin());
        user.setPassword(encoder.encode(userReq.getPassword()));
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        List<Rule> rules = ruleDao.findAll();
        user.setRules(rules);
        user.setRegistrationDate(LocalDateTime.now());
        user.setLastVisitTime(LocalDateTime.now());
        userDao.save(user);

        return 0;
    }

    @GetMapping("/logout-success")
    public int logout(){
        return 0;
    }

}
