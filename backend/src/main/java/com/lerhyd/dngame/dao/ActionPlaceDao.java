package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.ActionPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionPlaceDao extends JpaRepository<ActionPlace, Long> {

    ActionPlace findById(long id);

}
