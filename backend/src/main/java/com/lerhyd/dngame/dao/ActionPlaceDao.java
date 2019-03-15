package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.ActionPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionPlaceDao extends JpaRepository<ActionPlace, Integer> {

    ActionPlace findById(int id);

    @Query("select a from ActionPlace a where a.lvl<=lvl")
    List<ActionPlace> findByLvl(@Param("lvl") int lvl);

}
