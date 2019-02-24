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

    /**
     * Sign up in the system.
     * @param userReq Form of registration data from request.
     * @return Status:
     * 1 -- User with the login does not exist,
     * 2 -- The password does not match with retype password,
     * 3 -- Password's length is less than 8,
     * 4 -- Password contains non-Latin letters,
     * 0 -- The function was executed correctly.
     */
    @PostMapping("/signup")
    public int createUser(@RequestBody UserReq userReq){
        if (userDao.existsById(userReq.getLogin()))
            return 1;
        if (!userReq.getPassword().equals(userReq.getRetypePassword()))
            return 2;
        if (userReq.getPassword().length() < 8)
            return 3;
        if (!userReq.getPassword().matches("^[a-zA-Z0-9]+$"))
            return 4;
        Role userRole = roleDao.findById("user").get();
        User user = new User();
        user.setLogin(userReq.getLogin());
        user.setEmail(userReq.getEmail());
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
        emailService.sendMail("DN game.", user, "Вам необходимо подтвердить почту перед " +
                "тем как использовать аккаунт. Перейдите по этой ссылке:" +
                "http://localhost:1234/confirm/"+ user.getLogin() + "/" +token);
        return 0;
    }

    /**
     * Authenticate the user's email address through the comparison of the special tokens.
     * @param userLogin ID of user.
     * @param token The secret token.
     * @return Status:
     * 1 -- User with the login does not exist,
     * 2 -- The user's email address authentication failed,
     * 0 -- The function was executed correctly,
     */
    @GetMapping("/confirm/{userLogin}/{token}")
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

    /**
     * Change the user password.
     * @param newPass The new password.
     * @param login ID of user.
     * @return Status:
     * 1 -- User with the login does not exist,
     * 2 -- Password's length is less than 8,
     * 3 -- Password contains non-Latin letters,
     * 0 -- The function was executed correctly.
     */
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


    /**
     * Logout of the system.
     * @return Meaningless zero.
     */
    @GetMapping("/logout")
    public int logout(){
        return 0;
    }

    /**
     * Get new password on email.
     * @param email The user's email.
     * @return Status:
     * 1 -- There's no user with the email,
     * 2 -- User does not have role 'user',
     * 0 -- The function was executed correctly.
     */
    @GetMapping("/forgot/password")
    public int forgotPass(@RequestParam("email") String email){
        String token = java.util.UUID.randomUUID().toString();
        User user = userDao.findUserByEmail(email);
        if (user == null)
            return 1;
        if (user.getRoles().contains("user")) {
            changePass(token, user.getLogin());
            userDao.save(user);
            emailService.sendMail("DN game", user, "Ваш новый пароль: " + token);
        } else {
            return 2;
        }

        return 0;
    }
}
