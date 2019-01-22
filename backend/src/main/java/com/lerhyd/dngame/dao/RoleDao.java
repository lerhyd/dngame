package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, String> {

}
