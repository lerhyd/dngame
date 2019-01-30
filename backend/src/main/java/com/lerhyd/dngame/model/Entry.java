package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
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
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "page_number", nullable = false)
    private Integer pageNumber;

    @Column(name = "death_date")
    private LocalDateTime deathDataTime;

    @Column(name = "description_id")
    private String description;

    public Entry(Integer pageNumber, LocalDateTime deathDataTime, String description, DeathReason deathReason, DeathPlace deathPlace, Region deathRegion, Kira kira, Person victim) {
        this.pageNumber = pageNumber;
        this.deathDataTime = deathDataTime;
        this.description = description;
        this.deathReason = deathReason;
        this.deathPlace = deathPlace;
        this.deathRegion = deathRegion;
        this.kira = kira;
        this.victim = victim;
    }

    @ManyToOne
    @JoinColumn(name = "death_reason_id")
    private DeathReason deathReason;

    @ManyToOne
    @JoinColumn(name = "death_place_id")
    private DeathPlace deathPlace;

    @ManyToOne
    @JoinColumn(name = "death_region_id")
    private Region deathRegion;

    @ManyToOne
    @JoinColumn(name = "kira_id")
    private Kira kira;

    @OneToOne
    @JoinColumn(name = "victim_id")
    private Person victim;

}
