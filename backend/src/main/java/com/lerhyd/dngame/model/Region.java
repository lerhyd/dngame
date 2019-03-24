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
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "serial")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "continent")
    private String continent;

    @Column(name = "planet")
    private String planet;

    @OneToMany(mappedBy = "region")
    private Collection<Agent> agents;

    @OneToMany(mappedBy = "region")
    private Collection<Kira> kiras;

    @OneToMany(mappedBy = "commonRegion")
    private Collection<News> commonRegionNews;

    @OneToMany(mappedBy = "distributionRegion")
    private Collection<News> distributionRegionNews;

    @OneToMany(mappedBy = "crimeRegion")
    private Collection<Request> requests;

}
