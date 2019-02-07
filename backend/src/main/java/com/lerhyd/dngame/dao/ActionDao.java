package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionDao extends JpaRepository<Action, Integer> {

    Action findById(int id);

}
