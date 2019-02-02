package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Agent;
import com.lerhyd.dngame.model.Kira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface KiraDao extends JpaRepository<Kira, Long> {

    @Query("select k.points from Kira k where k.id = :id")
    Integer findPointsById(@Param("id") long id);

    @Query("select r.id from Kira k join k.region r where r.country=:country and r.city=:city")
    Long findRegionsIdByCountryAndCity(@Param("country") String country, @Param("city") String city);

    @Transactional
    @Modifying
    @Query("update Kira k set k.region.id=:regionId where k.id = :kiraId")
    void setRegion(@Param("kiraId") long kiraId, @Param("regionId") long regionId);

    Kira findById(long id);

    @Query("select k.numberOfKills from Kira k where k.id = :kiraId")
    int findKilledCriminalsByKiraId(@Param("kiraId") long kiraId);

    @Transactional
    @Modifying
    @Query("update Kira k set k.numberOfKills = k.numberOfKills + 1 where k.id = :kiraId")
    void addKilledCrimianl(@Param("kiraId") long kiraId);

    @Transactional
    @Modifying
    @Query("update Kira k set k.lvl = k.lvl + 1 where k.id = :id")
    void levelup(@Param("id") long kiraId);

    @Transactional
    @Modifying
    @Query("update Kira k set k.points= k.points + :points where k.id=:id")
    void addPoints(@Param("points") int points, @Param("id") long kiraId);

    @Transactional
    @Modifying
    @Query("update Kira k set k.points= k.points - :points where k.id=:id")
    void deletePoints(@Param("points") int points, @Param("id") long kiraId);

    @Query("select k from Kira k where k.news is empty")
    List<Kira> findKirasWithoutNews();

    @Query("select (count(k) > 0) from Kira k where k.id = :kiraId and k.news is not empty")
    boolean existsWithNewsByKiraId(@Param("kiraId") long kiraId);

}

