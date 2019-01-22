package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.RoleDao;
import com.lerhyd.dngame.dao.UserDao;
import com.lerhyd.dngame.model.Role;
import com.lerhyd.dngame.model.User;
import com.lerhyd.dngame.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@RestController()
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private AuthenticationManager authManager;

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/checkCookies")
    public ResponseEntity checkCookies(@RequestParam String username) {
        try {
            if (SecurityContextHolder.getContext().getAuthentication().getName().equals(username))
                return ResponseEntity.status(HttpStatus.OK).body("{\"authorized\": true}");
            else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"authorized\": false}");
        } catch (Exception e) {
            logger.error("An exception occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"authorized\": false}");
        }
    }

    @PostMapping(value = "/registration")
    public ResponseEntity createNewUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (user.getLogin().equalsIgnoreCase("SYSTEM"))
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("{\"text\":\"'SYSTEM' in any case is a reserved word. Users can not use it as their usernames.\"}");
        User userExists = userService.getUser(user.getLogin());
        if (userExists != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"text\":\"This username is already occupied\"}");
        }
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"text\":\"User object validation failed.\"}");
        }

        Role userRole = roleDao.findById("USER").get();
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setRegistrationDate(LocalDateTime.now());
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"text\":\"User successfully registered!\"}");
    }

    @GetMapping("users/{login}")
    public User getUser(@PathVariable("login") String login){
        User user = userDao.getOne(login);

        return user;
    }

    @PostMapping("/confirm")
    public ResponseEntity confirm(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {
        if (login.equalsIgnoreCase("SYSTEM"))
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("{\"text\":\"'SYSTEM' in any case is a reserved word. Users can not use it as their usernames.\"}");
        if (!userService.exists(login)) {
            if (password.length() >= 6 || password.isEmpty()) {
                User user = new User(login, password.isEmpty() ? null : password);
                String tmpName = SecurityContextHolder.getContext().getAuthentication().getName();
                if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("NEWGoogle"))) {
                    String email = tmpName.substring(3);
                    user.setEmail(email);
                } else {
                    int vkId = Integer.parseInt(tmpName.substring(3));
                    user.setVkId(vkId);
                }
                user.setRegistrationDate(LocalDateTime.now());
                userService.saveUser(user);
                UsernamePasswordAuthenticationToken authReq
                        = new UsernamePasswordAuthenticationToken(user, password);
                Authentication auth = authManager.authenticate(authReq);
                SecurityContextHolder.getContext().setAuthentication(auth);
                return ResponseEntity.status(HttpStatus.CREATED).body("{\"text\":\"User successfully registered!\"}");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"text\":\"Password is too short.\"}");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"text\":\"This username is already occupied\"}");
    }

}