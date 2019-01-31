package com.lerhyd.dngame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link Rank},
 * describes the rank of player.
 */


@Data
@Entity
@Table(name = "rank")
public class Rank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "level", nullable = false)
    private int lvl;

    @Column(name = "rank", length = 50)
    private String rank;

    @OneToMany(mappedBy = "rank")
    private Collection<Agent> agents;

    @OneToMany(mappedBy = "rank")
    private Collection<Kira> kiras;

}
