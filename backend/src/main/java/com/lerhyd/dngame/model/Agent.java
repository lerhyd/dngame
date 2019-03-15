package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Simple JavaBean object that represents role of {@link Agent},
 * describes the game class "Agent".
 */


@Data
@Entity
@Table(name = "agents")

public class Agent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "serial")
    private int id;

    @Column(name = "lvl")
    private int lvl;

    @Column(name = "number_of_caught_killers")
    private int numberOfCaughtKillers;

    @Column(name = "number_of_wins")
    private int numberOfWins;

    @Column(name = "number_of_loses")
    private int numberOfLoses;

    @Column(name = "points")
    private int points;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "achievements_to_agent",
            joinColumns = @JoinColumn(name = "agent_id"),
            inverseJoinColumns = @JoinColumn(name = "achievements_id")
    )
    private List<Achievement> achievements;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false, columnDefinition = "integer")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "rank_id", columnDefinition = "integer")
    private Rank rank;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<News> news;

    @OneToMany(mappedBy = "agent")
    private List<Request> requests;

    @OneToOne(mappedBy = "agent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

}
