package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.SupposedVictim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupposedVictimDao extends JpaRepository<SupposedVictim, Long> {

    SupposedVictim findById(long id);

}
