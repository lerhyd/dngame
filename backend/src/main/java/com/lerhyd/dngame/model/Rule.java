package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Simple JavaBean object that represents role of {@link Rule},
 * describes game rules.
 */


@Data
@Entity
@Table(name = "note_rules")
public class Rule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault;

    @Column(name = "description", unique = true)
    private String description;

    @ManyToMany(mappedBy = "rules")
    private Set<Kira> kiras;

    @ManyToMany(mappedBy = "rules")
    private Set<Agent> agents;

}
