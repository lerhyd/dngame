package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @SequenceGenerator(name = "request_seq", sequenceName = "request_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "request_seq")
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "page_number", nullable = false)
    private int pageNumber;

    @Column(name = "is_success")
    private boolean success;

    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;

    @ManyToOne
    @JoinColumn(name = "crime_region_id")
    private Region crimeRegion;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToOne
    @JoinColumn(name = "crime_person_id")
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
