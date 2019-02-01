package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link Action},
 * describes the action that is in news.
 */


@Data
@Entity
@Table(name = "actions")
public class Action implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "lvl")
    private int lvl;

    @OneToMany(mappedBy = "action")
    private Collection<News> news;

    @OneToMany(mappedBy = "action")
    private Collection<Entry> entries;

    public Action(){}

    public Action(String description, int lvl, Collection<News> news, Collection<Entry> entries) {
        this.description = description;
        this.lvl = lvl;
        this.news = news;
        this.entries = entries;
    }
}
