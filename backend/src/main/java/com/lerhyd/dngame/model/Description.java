package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link Description},
 * describes how human died in note's entry.
 */


@Data
@Entity
@Table(name = "descriptions")
public class Description implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "description", length = 500, unique = true)
    private String description;

    @OneToMany(mappedBy = "description")
    private Collection<Entry> entries;

}
