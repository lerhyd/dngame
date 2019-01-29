package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionDao extends JpaRepository<Region, Long> {

    Region findById(long id);

}
