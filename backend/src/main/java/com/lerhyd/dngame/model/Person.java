package com.lerhyd.dngame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;

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
    private Long id;

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
    private boolean isFake;

    @OneToOne(mappedBy = "person")
    private Agent agent;

    @OneToOne(mappedBy = "person")
    private Kira kira;

    @OneToOne(mappedBy = "victim")
    private Entry entry;

    @OneToMany(mappedBy = "victim")
    private Collection<News> newsVictim;

    @OneToMany(mappedBy = "killer")
    private Collection<News> newsKiller;

}
