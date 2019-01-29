package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Kira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface KiraDao extends JpaRepository<Kira, Long> {

    @Query("select k.points from Kira k where k.id = :id")
    Integer findPointsById(@Param("id") Long id);

    @Query("select r.id from Kira k join k.region r where r.country=:country and r.city=:city")
    Long findRegionsIdByCountryAndCity(@Param("country") String country, @Param("city") String city);

    @Transactional
    @Modifying
    @Query("update Kira k set k.region.id=:regionId where k.id = :kiraId")
    void setRegion(@Param("kiraId") Long kiraId, @Param("regionId") Long regionId);

    Kira findById(long id);

}

