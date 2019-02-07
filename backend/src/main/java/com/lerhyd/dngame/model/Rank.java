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
@Table(name = "ranks")
public class Rank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "serial")
    private int id;

    @Column(name = "points", nullable = false)
    private int points;

    @Column(name = "rank", length = 50)
    private String rank;

    @Column(name="is_kira")
    private boolean kira;

    @OneToMany(mappedBy = "rank")
    private Collection<Agent> agents;

    @OneToMany(mappedBy = "rank")
    private Collection<Kira> kiras;

}
