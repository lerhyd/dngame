package com.lerhyd.dngame.dao;


import com.lerhyd.dngame.model.DeathReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathReasonDao extends JpaRepository<DeathReason, Long> {

    DeathReason findById(long id);

}
