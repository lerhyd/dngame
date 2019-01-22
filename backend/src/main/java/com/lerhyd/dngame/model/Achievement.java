package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link Achievement},
 * describes the achievements a player can get.
 */


@Data
@Entity
@Table(name = "achievements")
public class Achievement implements Serializable {

    @Id
    @Column(name = "title", nullable = false, length = 50, unique = true)
    private String title;

    @Column(name = "task")
    private String task;

    @Column(name = "description")
    private String description;

    @Column(name = "is_kiras")
    private Boolean isKiras;

    @ManyToMany(mappedBy = "achievements")
    private Collection<Agent> agents;

    @ManyToMany(mappedBy = "achievements")
    private Collection<Kira> kiras;

}
