package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionDao extends JpaRepository<Action, Integer> {

    Action findById(int id);

    @Query("select a from Action a where a.lvl<=:lvl and a.id <> 1")
    List<Action> findByLvl(@Param("lvl") int lvl);

}
