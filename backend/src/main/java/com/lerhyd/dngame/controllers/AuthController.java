package com.lerhyd.dngame.controllers;

import com.lerhyd.dngame.dao.RoleDao;
import com.lerhyd.dngame.dao.RuleDao;
import com.lerhyd.dngame.dao.UserDao;
import com.lerhyd.dngame.model.Role;
import com.lerhyd.dngame.model.Rule;
import com.lerhyd.dngame.model.User;
import com.lerhyd.dngame.request.UserReq;
import com.lerhyd.dngame.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
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

    @Autowired
    private EmailService emailService;

    @PostMapping("/signup")
    public int createUser(@RequestBody @Valid UserReq userReq, BindingResult bindingResult){
        if (userDao.existsById(userReq.getLogin()))
            return 1;
        if (bindingResult.hasErrors())
            return 2;
        if (!userReq.getPassword().equals(userReq.getRetypePassword()))
            return 3;
        if (userReq.getPassword().length() < 8)
            return 4;
        if (!userReq.getPassword().matches("^[a-zA-Z0-9]+$"))
            return 5;
        Role userRole = roleDao.findById("user").get();
        User user = new User();
        user.setLogin(userReq.getLogin());
        user.setPassword(encoder.encode(userReq.getPassword()));
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        List<Rule> rules = ruleDao.findAll();
        user.setRules(rules);
        user.setRegistrationDate(LocalDateTime.now());
        user.setLastVisitTime(LocalDateTime.now());
        user.setConfirmed(false);
        String token = java.util.UUID.randomUUID().toString();
        user.setToken(token);
        userDao.save(user);
        emailService.sendMail("DN game.", user, "Вам необходимо подтвердить почту перед тем как использовать аккаунт. Перейдите по этой ссылке:" +
                "http://localhost:1234/confirm/"+ user.getLogin() + "/" +token);
        return 0;
    }

    @PostMapping("/confirm/{userLogin}/{token}")
    public int confirm(@PathVariable("userLogin") String userLogin, @PathVariable("token") String token){
        if (userDao.getOne(userLogin) == null)
            return 1;
        if (!userDao.getOne(userLogin).getToken().equals(token))
            return 2;
        User user = userDao.getOne(userLogin);
        user.setConfirmed(true);
        userDao.save(user);
        return 0;
    }

    @PostMapping("/changepass")
    public int changePass(@RequestParam("newPass") String newPass, @RequestParam("login") String login){
        if (userDao.findById(login) == null)
            return 1;
        if (newPass.length() < 8)
            return 2;
        if (!newPass.matches("^[a-zA-Z0-9]+$"))
            return 3;
        User user = userDao.getOne(login);
        user.setPassword(encoder.encode(newPass));
        userDao.save(user);
        return 0;
    }

    @GetMapping("/get")
    public Collection<? extends GrantedAuthority> get(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    @GetMapping("/logout")
    public int logout(){
        return 0;
    }

}
