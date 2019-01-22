package com.lerhyd.dngame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Simple JavaBean object that represents role of {@link Kira},
 * describes the game class "Agent".
 */


@Data
@Entity
@Table(name = "kira")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Kira implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonManagedReference
    private Person person;

    @Column(name = "number_of_kills")
    private Integer numberOfKills;

    @Column(name = "points")
    private Integer points;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "achievements_to_kira",
            joinColumns = @JoinColumn(name = "kira_id"),
            inverseJoinColumns = @JoinColumn(name = "achievements_id")
    )
    private Collection<Achievement> achievements;

    @OneToMany(mappedBy = "kira")
    private Collection<Entry> entries;

    @OneToMany(mappedBy = "kira", cascade = CascadeType.ALL)
    private Collection<News> news;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    @JsonManagedReference
    private Region region;

    @ManyToOne
    @JoinColumn(name = "rank_id", nullable = false)
    @JsonManagedReference
    private Rank rank;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "note_rule_to_kira",
            joinColumns = @JoinColumn(name = "kira_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Collection<NoteRule> noteRules;

    @OneToOne(mappedBy = "kira")
    @JsonIgnore
    private User user;

}
