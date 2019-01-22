package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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
    private Date deathDate;

    @Column(name = "death_time")
    private Time deathTime;

    @ManyToOne
    @JoinColumn(name = "reason_id")
    private DeathReason deathReason;

    @ManyToOne
    @JoinColumn(name = "death_place_id")
    private DeathPlace deathPlace;

    @ManyToOne
    @JoinColumn(name = "description_id")
    private Description description;

    @ManyToOne
    @JoinColumn(name = "kira_id")
    private Kira kira;

    @OneToOne
    @JoinColumn(name = "victim_id")
    private Person victim;

}
