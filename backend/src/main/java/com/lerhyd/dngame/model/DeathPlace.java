package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link DeathPlace},
 * describes where human died in note's entry.
 */


@Data
@Entity
@Table(name = "death_places")
public class DeathPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "death_place", nullable = true, length = 500, unique = true)
    private String deathPlace;

    @OneToMany(mappedBy = "deathPlace")
    private Collection<Entry> entries;

}
