package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}