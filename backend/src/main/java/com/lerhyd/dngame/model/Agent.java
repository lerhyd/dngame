package com.lerhyd.dngame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "lvl")
    private Integer lvl;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonManagedReference
    private Person person;

    @Column(name = "number_of_caught_killers")
    private Integer numberOfCaughtKillers;

    @Column(name = "points")
    private Integer points;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "achievements_to_agent",
            joinColumns = @JoinColumn(name = "agent_id"),
            inverseJoinColumns = @JoinColumn(name = "achievements_id")
    )
    private Collection<Achievement> achievements;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    @JsonManagedReference
    private Region region;

    @ManyToOne
    @JoinColumn(name = "rank_id", nullable = false)
    @JsonManagedReference
    private Rank rank;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private Collection<News> news;

    @OneToOne(mappedBy = "agent", cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

}
