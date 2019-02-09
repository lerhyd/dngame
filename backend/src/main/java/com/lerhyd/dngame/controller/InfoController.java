package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.PersonDao;
import com.lerhyd.dngame.info.PersonInfo;
import com.lerhyd.dngame.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class InfoController {

    @Autowired
    private PersonDao personDao;

    @GetMapping("/game/persons/get")
    public Stream<PersonInfo> getPersons(@RequestParam("id") int agentId){
        List<Person> people = personDao.findAllAlivePersonsByAgentId(agentId);
        return people.stream().map(PersonInfo::new);
    }

}
