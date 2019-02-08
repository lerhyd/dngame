package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface AgentDao extends JpaRepository<Agent, Integer> {

    @Query("select a.points from Agent a where a.id = :id")
    Integer findPointsById(@Param("id")int id);

    @Query("select region.id from Agent a left join a.region region where region.country=:country and region.city =:city")
    int findRegionsIdByCountryAndCity(@Param("country")String country, @Param("city")String city);

    @Transactional
    @Modifying
    @Query("update Agent set region=:regionId where id = :agentId")
    void setRegionByAgentIdAndRegionId(@Param("agentId") int agentId, @Param("regionId") int regionId);

    Agent findById(int id);

    @Query("select a from Agent a where a.news is empty")
    List<Agent> findAgentsWithoutNews();

    @Query("select (count(a) > 0) from Agent a where a.id = :agentId and a.news is not empty ")
    boolean existsWithNewsByAgentId(@Param("agentId") int agentId);

    @Transactional
    @Modifying
    @Query("update Agent a set a.points= a.points + :points where a.id=:id")
    void addPoints(@Param("points") int points, @Param("id") int agentId);

    @Transactional
    @Modifying
    @Query("update Agent a set a.points= a.points - :points where a.id=:id")
    void deletePoints(@Param("points") int points, @Param("id") int agentId);

    @Transactional
    @Modifying
    @Query("update Agent a set a.numberOfCaughtKillers = a.numberOfCaughtKillers + 1 where a.id=:id")
    void addNumberOfRightCaught(@Param("id") int agentId);
}