package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Person;

public class PersonInfo {

    public long id;
    public String name;
    public String surname;
    public String patr;
    public boolean sex;
    public boolean isFake;
    public String bornDate;
    public String deathDate;

    private PersonInfo(){}

    public PersonInfo(Person p){
        id = p.getId();
        name = p.getName();
        surname = p.getSurname();
        patr = p.getPatronymic();
        sex = p.getSex();
        isFake = p.isFake();
        bornDate = p.getBornDate().toLocalDate().toString();
        deathDate = p.getDeathDate().toLocalDate().toString();
    }
}
