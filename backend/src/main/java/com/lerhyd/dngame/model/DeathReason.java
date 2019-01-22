package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link DeathReason},
 * describes death reason in note's entry.
 */


@Data
@Entity
@Table(name = "death_reasons")
public class DeathReason implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "death_reason", length = 500, unique = true)
    private String deathReason;

    @OneToMany(mappedBy = "deathReason")
    private Collection<Entry> entries;

}
