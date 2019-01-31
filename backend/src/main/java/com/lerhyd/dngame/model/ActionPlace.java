package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link ActionPlace},
 * describes where human died in note's entry.
 */


@Data
@Entity
@Table(name = "death_places")
public class ActionPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "death_place", length = 500, unique = true)
    private String place;

    @Column(name = "lvl")
    private int lvl;

    @OneToMany(mappedBy = "actionPlace")
    private Collection<News> news;

    @OneToMany(mappedBy = "actionPlace")
    private Collection<Entry> entries;

    public ActionPlace(){}

    public ActionPlace(String place, int lvl, Collection<Entry> entries, Collection<News> news) {
        this.place = place;
        this.lvl = lvl;
        this.entries = entries;
        this.news = news;
    }
}
