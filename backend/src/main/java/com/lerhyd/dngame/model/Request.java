package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "serial")
    private int id;

    @Column(name = "page_number", nullable = false)
    private int pageNumber;

    @Column(name = "is_success")
    private boolean success;

    @ManyToOne
    @JoinColumn(name = "action_id", columnDefinition = "integer")
    private Action action;

    @ManyToOne
    @JoinColumn(name = "crime_region_id", columnDefinition = "integer")
    private Region crimeRegion;

    @ManyToOne
    @JoinColumn(name = "agent_id", columnDefinition = "integer")
    private Agent agent;

    @OneToOne
    @JoinColumn(name = "crime_person_id", columnDefinition = "integer")
    private Person crimePerson;

    public Request(){}

    public Request(int pageNumber, boolean success, Action action, Region crimeRegion, Agent agent, Person crimePerson) {
        this.pageNumber = pageNumber;
        this.success = success;
        this.action = action;
        this.crimeRegion = crimeRegion;
        this.agent = agent;
        this.crimePerson = crimePerson;
    }
}
