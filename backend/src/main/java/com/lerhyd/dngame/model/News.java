package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Simple JavaBean object that represents role of {@link News},
 * describes world news.
 */


@Data
@Entity
@Table(name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "what_did", nullable = false, length = 500)
    private String whatDid;

    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;

    @Column(name = "publication_time", nullable = false)
    private Time publicationTime;

    @OneToOne
    @JoinColumn(name = "action_id")
    private Action action;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "kira_id")
    private Kira kira;

    @ManyToOne
    @JoinColumn(name = "distribution_region_id")
    private Region distributionRegion;

    @ManyToOne
    @JoinColumn(name = "where_did_id")
    private Region whereDid;

    @OneToOne
    @JoinColumn(name = "over_whom_did_id")
    private SupposedVictim supposedVictim;

    @ManyToOne
    @JoinColumn(name = "killer_id")
    private Person killer;

}
