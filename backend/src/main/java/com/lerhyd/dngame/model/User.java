package com.lerhyd.dngame.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Simple JavaBean object that represents role of {@link User}
 */


@Data
@Entity
@Table(name = "users")
public class User{

    @Id
    @NotEmpty
    @Column(name = "login", nullable = false, length = 30, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "vk_id")
    private Integer vkId;

    @Column(name = "registration_date", updatable = false)
    private LocalDateTime registrationDate;

    @Column(name = "last_visit_timestamp")
    private LocalDateTime lastVisitTime;

    @OneToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToOne
    @JoinColumn(name = "kira_id")
    private Kira kira;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "login"), inverseJoinColumns = @JoinColumn(name = "role"))
    private Set<Role> roles;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(){

    }
}
