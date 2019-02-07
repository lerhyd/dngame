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
@Table(name = "kiras")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Kira implements Serializable {

    @Id
    @SequenceGenerator(name = "kira_seq", sequenceName = "kira_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "kira_seq")
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "lvl")
    private int lvl;

    @Column(name = "number_of_kills")
    private int numberOfKills;

    @Column(name = "number_of_wins")
    private int numberOfWins;

    @Column(name = "number_of_loses")
    private int numberOfLoses;

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

    @OneToOne(mappedBy = "kira", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "kira")
    private List<Entry> entries;

}
