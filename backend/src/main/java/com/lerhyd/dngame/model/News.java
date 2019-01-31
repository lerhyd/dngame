package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Simple JavaBean object that represents role of {@link News},
 * describes world news.
 */


@Data
@Entity
@Table(name = "news")
public class News implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "what", nullable = false, length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;

    @ManyToOne
    @JoinColumn(name = "actionPlace")
    private ActionPlace actionPlace;

    @ManyToOne
    @JoinColumn(name = "victim_id")
    private Person victim;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "kira_id")
    private Kira kira;

    @ManyToOne
    @JoinColumn(name = "distribution_region_id")
    private Region distributionRegion;

    @ManyToOne
    @JoinColumn(name = "common_region_id")
    private Region commonRegion;

    @OneToOne
    @JoinColumn(name = "fake_victim_id")
    private Person fakeVictim;

    @ManyToOne
    @JoinColumn(name = "killer_id")
    private Person killer;

    public News(){

    }

    public News(String description, Action action, ActionPlace actionPlace, Person victim, Agent agent, Kira kira, Region distributionRegion, Region commonRegion, Person fakeVictim, Person killer) {
        this.description = description;
        this.action = action;
        this.actionPlace = actionPlace;
        this.victim = victim;
        this.agent = agent;
        this.kira = kira;
        this.distributionRegion = distributionRegion;
        this.commonRegion = commonRegion;
        this.fakeVictim = fakeVictim;
        this.killer = killer;
    }
}
