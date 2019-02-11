package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleDao extends JpaRepository<Rule, Integer> {

    Rule findById(int id);

}
