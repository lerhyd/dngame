package com.lerhyd.dngame.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="roles")
public class Role {

    @Id
    @Column(name="role", length=8)
    private String role;

    public Role(){}

    public Role(String role) {
        this.role = role;
    }

}
