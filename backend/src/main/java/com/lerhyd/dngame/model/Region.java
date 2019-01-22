package com.lerhyd.dngame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link Region},
 * describes region in the game world.
 */


@Data
@Entity
@Table(name = "regions")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "region")
    @JsonBackReference
    private Collection<Agent> agents;

    @OneToMany(mappedBy = "region")
    @JsonBackReference
    private Collection<Kira> kiras;

    @OneToMany(mappedBy = "whereDid")
    private Collection<News> whereNews;

    @OneToMany(mappedBy = "distributionRegion")
    private Collection<News> distributionNews;

}
