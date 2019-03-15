package com.lerhyd.dngame.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Simple JavaBean object that represents role of {@link Rule},
 * describes game rules.
 */


@Data
@Entity
@Table(name = "rules")
@ToString(exclude = {"users"})
public class Rule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "serial")
    private int id;

    @Column(name = "description", unique = true)
    private String description;

    @ManyToMany(mappedBy = "rules")
    private List<User> users;

}
