package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Simple JavaBean object that represents role of {@link Entry},
 * describes an entry in a note.
 */


@Data
@Entity
@Table(name = "entries")
public class Entry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "serial")
    private int id;

    @Column(name = "page_number", nullable = false)
    private int pageNumber;

    @Column(name = "death_date")
    private LocalDateTime deathDataTime;

    @Column(name = "description_id")
    private String description;

    @ManyToOne
    @JoinColumn(name = "action_id", columnDefinition = "integer")
    private Action action;

    @ManyToOne
    @JoinColumn(name = "action_place_id", columnDefinition = "integer")
    private ActionPlace actionPlace;

    @ManyToOne
    @JoinColumn(name = "death_region_id", columnDefinition = "integer")
    private Region deathRegion;

    @ManyToOne
    @JoinColumn(name = "kira_id", columnDefinition = "integer")
    private Kira kira;

    @OneToOne
    @JoinColumn(name = "victim_id", columnDefinition = "integer")
    private Person victim;

    public Entry(int pageNumber, LocalDateTime deathDataTime, String description, Action action, ActionPlace actionPlace, Region deathRegion, Kira kira, Person victim) {
        this.pageNumber = pageNumber;
        this.deathDataTime = deathDataTime;
        this.description = description;
        this.action = action;
        this.actionPlace = actionPlace;
        this.deathRegion = deathRegion;
        this.kira = kira;
        this.victim = victim;
    }

    public Entry(){}
}
