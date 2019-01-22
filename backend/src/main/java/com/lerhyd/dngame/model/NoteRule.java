package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link NoteRule},
 * describes game rules.
 */


@Data
@Entity
@Table(name = "note_rules")
public class NoteRule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault;

    @Column(name = "description", unique = true)
    private String description;

    @ManyToMany(mappedBy = "noteRules")
    private Collection<Kira> kiras;

}
