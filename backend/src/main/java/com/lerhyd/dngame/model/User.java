package com.lerhyd.dngame.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
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

    @Column
    private String token;

    @Column
    private boolean confirmed;

    @Column(name = "registration_date", updatable = false)
    private LocalDateTime registrationDate;

    @Column(name = "last_visit_timestamp")
    private LocalDateTime lastVisitTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", columnDefinition = "integer")
    private Agent agent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kira_id", columnDefinition = "integer")
    private Kira kira;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "login"), inverseJoinColumns = @JoinColumn(name = "role"))
    private Set<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "rules_to_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private List<Rule> rules;

    @OneToOne
    @JoinColumn(name = "profile_id", columnDefinition = "integer")
    private Person profile;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(){

    }
}
