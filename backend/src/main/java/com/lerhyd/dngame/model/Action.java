package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
    private Long id;

    @Column(name = "description", length = 55)
    private String description;

    @OneToOne(mappedBy = "action", cascade = CascadeType.ALL)
    private News news;

    public Action(){}

    public Action(String description, News news) {
        this.description = description;
        this.news = news;
    }
}
