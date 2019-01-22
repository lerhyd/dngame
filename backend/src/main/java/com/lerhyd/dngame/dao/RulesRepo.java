package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.NoteRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RulesRepo extends JpaRepository<NoteRule, Integer> {

}
