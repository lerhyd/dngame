package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface NewsDao extends JpaRepository<News, Integer> {

    @Query("select n from News n where n.kira.id=:kiraId and n.agent.id = :agentId")
    List<News> findAllByKiraAndAgent(@Param("kiraId") int kiraId, @Param("agentId") int agentId);

    @Transactional
    @Modifying
    @Query("delete from News n where n.kira.id = :kiraId and n.agent.id = :agentId")
    void deleteAllByKiraIdAndAgentId(@Param("kiraId") int kiraId, @Param("agentId") int agentId);

    News findById(int id);

    @Query("select n from News n where n.publicationDate <= current_timestamp and n.kira.id=:kiraId and n.agent.id=:agentId")
    List<News> findAllNewsByAgent_IdAndKira_Id(@Param("kiraId") int kiraId, @Param("agentId") int agentId);

    @Query("select count(n) from News n where n.kira.id = :kiraId and n.agent.id = :agentId")
    int cntNewsByKiraAndAgent(@Param("kiraId") int kiraId, @Param("agentId") int agentId);

    @Query("select n from News n where n.kira is empty and n.agent is empty and n.id = :id")
    News findNewsTemplate(@Param("id") int id);

    @Query("select n from News n where n.kira is empty and n.agent is empty order by function('RAND')")
    List<News> findAllTempleteNewsInRandomOrder();

    @Query("select (count(n) > 0) from News n where n.agentGenerated=true and n.guiltyPerson.id=:personId and n.kira.id=:kiraId")
    boolean findIfNewsIsAgentGenerated(@Param("personId") int personId, @Param("kiraId") int kiraId);

    @Query("select (count(n) > 0) from News n where n.kira.region.id=n.distributionRegion.id and n.agentGenerated=true " +
            "and n.guiltyPerson.id=:personId and n.kira.id=:kiraId")
    boolean findIfKiraWasFound(@Param("personId") int personId, @Param("kiraId") int kiraId);

    @Query("select n from News n where n.publishedForKira=false and n.kira.id=:kiraId and n.agent.id=:agentId")
    List<News> findNotPublishedNewsForKiraByKiraIdAndAgentId(@Param("kiraId") int kiraId, @Param("agentId") int agentId);

    @Query("select n from News n where n.publishedForAgent=false and n.kira.id=:kiraId and n.agent.id=:agentId")
    List<News> findNotPublishedNewsForAgentByKiraIdAndAgentId(@Param("kiraId") int kiraId, @Param("agentId") int agentId);

}