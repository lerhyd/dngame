package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionDao extends JpaRepository<Region, Integer> {

    Region findById(int id);

    @Query("select r from Region r where r.city is not null order by function('RAND')")
    List<Region> findAllRegionsInRandomOrder();
}
