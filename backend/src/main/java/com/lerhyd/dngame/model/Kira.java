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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "serial")
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
    private List<Achievement> achievements;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false, columnDefinition = "integer")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "rank_id", columnDefinition = "integer")
    private Rank rank;

    @OneToMany(mappedBy = "kira", cascade = CascadeType.ALL)
    private List<News> news;

    @OneToOne(mappedBy = "kira", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "kira")
    private List<Entry> entries;

}
