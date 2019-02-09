package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Person;

public class PersonInfo {

    public Integer id;
    public String name;
    public String surname;
    public String patr;
    public boolean sex;
    public boolean fake;
    public boolean criminal;
    public String bornDate;
    public String deathDate;

    private PersonInfo(){}

    public PersonInfo(Person p){
        id = p.getId();
        name = p.getName();
        surname = p.getSurname();
        patr = p.getPatronymic();
        sex = p.getSex();
        fake = p.isFake();
        criminal = p.isCriminal();
        bornDate = p.getBornDate().toLocalDate().toString();
    }
}
