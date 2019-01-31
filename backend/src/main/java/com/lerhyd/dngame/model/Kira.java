package com.lerhyd.dngame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Simple JavaBean object that represents role of {@link Kira},
 * describes the game class "Agent".
 */


@Data
@Entity
@Table(name = "kira")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Kira implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "lvl")
    private int lvl;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "number_of_kills")
    private int numberOfKills;

    @Column(name = "points")
    private int points;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "achievements_to_kira",
            joinColumns = @JoinColumn(name = "kira_id"),
            inverseJoinColumns = @JoinColumn(name = "achievements_id")
    )
    private Collection<Achievement> achievements;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "rule_to_kira",
            joinColumns = @JoinColumn(name = "kira_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<Rule> rules;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @ManyToOne
    @JoinColumn(name = "rank_id", nullable = false)
    private Rank rank;

    @OneToMany(mappedBy = "kira", cascade = CascadeType.ALL)
    private List<News> news;

    @OneToOne(mappedBy = "kira")
    private User user;

    @OneToMany(mappedBy = "kira")
    private Collection<Entry> entries;

}
