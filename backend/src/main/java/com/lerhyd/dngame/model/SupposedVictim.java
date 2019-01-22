package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Simple JavaBean object that represents role of {@link SupposedVictim},
 * describes supposed victim for agent's fake news.
 */


@Data
@Entity
@Table(name = "supposed_victim")
public class SupposedVictim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", length = 55)
    private String name;

    @Column(name = "surname", length = 55)
    private String surname;

    @Column(name = "patronymic", length = 55)
    private String patronymic;

    @OneToOne(mappedBy = "supposedVictim", cascade = CascadeType.ALL)
    private News news;

}
