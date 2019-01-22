package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.DeathPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathPlaceDao extends JpaRepository<DeathPlace, Integer> {

}
