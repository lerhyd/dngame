package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionDao extends JpaRepository<Description, Integer> {

}