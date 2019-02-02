package com.lerhyd.dngame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * Simple JavaBean object that represents role of {@link Person},
 * describes the person of the game world.
 */


@Data
@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Column(name = "surname", length = 20)
    private String surname;

    @Column(name = "patronymic", length = 20)
    private String patronymic;

    @Column(name = "sex")//man = true, woman = false
    private Boolean sex;

    @Column(name = "born_date", nullable = false)
    private LocalDateTime bornDate;

    @Column(name = "death_date")
    private LocalDateTime deathDate;

    @Column(name = "is_fake")
    private boolean fake;

    @Column(name = "is_criminal")
    private boolean criminal;

    @OneToOne(mappedBy = "victim", cascade=CascadeType.ALL)
    private Entry entry;

    @OneToOne(mappedBy = "profile")
    private User user;

    @OneToMany(mappedBy = "victim")
    private List<News> newsVictim;

    @OneToMany(mappedBy = "killer")
    private List<News> newsKiller;

    public Person(String name, String surname, String patronymic, Boolean sex, LocalDateTime bornDate,
                  LocalDateTime deathDate, boolean fake, boolean criminal, Entry entry,
                  List<News> newsVictim, List<News> newsKiller) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.bornDate = bornDate;
        this.deathDate = deathDate;
        this.fake = fake;
        this.criminal = criminal;
        this.entry = entry;
        this.newsVictim = newsVictim;
        this.newsKiller = newsKiller;
    }

    public Person(){}
}
