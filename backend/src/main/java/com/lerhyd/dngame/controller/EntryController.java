package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.EntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

    @Autowired
    private EntryDao entryDao;

    @PostMapping("/entry/add")
    public void addEntry(){

    }

}
