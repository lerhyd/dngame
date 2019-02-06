package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "page_number", nullable = false)
    private int pageNum;

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

    public Request(int pageNum, boolean success, Action action, Region crimeRegion, Agent agent, Person crimePerson) {
        this.pageNum = pageNum;
        this.success = success;
        this.action = action;
        this.crimeRegion = crimeRegion;
        this.agent = agent;
        this.crimePerson = crimePerson;
    }
}
