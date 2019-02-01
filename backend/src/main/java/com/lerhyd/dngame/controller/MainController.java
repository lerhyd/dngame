package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.AgentDao;
import com.lerhyd.dngame.dao.KiraDao;
import com.lerhyd.dngame.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private PersonDao personDao;

    @PostMapping("/game/class")
    public void setMainClass(@RequestParam("isKira") boolean isKira, @RequestParam("userLogin") String userLogin){
        if (isKira){

        }
    }

}
