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
    @SequenceGenerator(name = "news_seq", sequenceName = "news_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "news_seq")
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "victim_exists")
    private boolean victimExists;

    @Column(name = "is_fake")
    private boolean fake;

    @Column(name = "is_agent")
    private boolean agentGenerated;

    @Column(name = "is_die")
    private boolean die;

    @Column(name = "what", nullable = false, length = 500)
    private String description;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;

    @ManyToOne
    @JoinColumn(name = "action_place")
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

    @ManyToOne
    @JoinColumn(name = "guilty_person_id")
    private Person guiltyPerson;

    public News(){

    }

    public News(boolean victimExists, boolean fake, boolean agentGenerated, boolean die, String description, LocalDateTime publicationDate, Action action, ActionPlace actionPlace, Person victim, Agent agent, Kira kira, Region distributionRegion, Region commonRegion, Person guiltyPerson) {
        this.victimExists = victimExists;
        this.fake = fake;
        this.agentGenerated = agentGenerated;
        this.die = die;
        this.description = description;
        this.publicationDate = publicationDate;
        this.action = action;
        this.actionPlace = actionPlace;
        this.victim = victim;
        this.agent = agent;
        this.kira = kira;
        this.distributionRegion = distributionRegion;
        this.commonRegion = commonRegion;
        this.guiltyPerson = guiltyPerson;
    }
}
