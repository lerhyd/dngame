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
public interface AgentDao extends JpaRepository<Agent, Long> {

    @Query("select a.points from Agent a where a.id = :id")
    Integer findPointsById(@Param("id")Long id);

    @Query("select region.id from Agent a left join a.region region where region.country=:country and region.city =:city")
    Long findRegionsIdByCountryAndCity(@Param("country")String country, @Param("city")String city);

    @Transactional
    @Modifying
    @Query("update Agent set region=:regionId where id = :agentId")
    void setRegionByAgentIdAndRegionId(@Param("agentId") Long agentId, @Param("regionId") Long regionId);

    Agent findById(long id);

    @Query("select a from Agent a where a.news is empty")
    List<Agent> findAgentsWithoutNews();

    @Query("select (count(a) > 0) from Agent a where a.id = :agentId and a.news is not empty ")
    boolean existsWithNewsByAgentId(@Param("agentId") long agentId);
}