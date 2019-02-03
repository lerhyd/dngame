package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NewsDao extends JpaRepository<News, Long> {

    @Query("select n from News n where n.kira.id=:kiraId and n.agent.id = :agentId")
    List<News> findAllByKiraAndAgent(@Param("kiraId") Long kiraId, @Param("agentId") Long agentId);

    @Query("select n from News n where n.agent.id = :agentId")
    List<News> findAllByAgentId(@Param("agentId") Long agentId);

    List<News> findNewsByKiraId(long kiraId);

    @Transactional
    @Modifying
    @Query("delete from News n where n.kira.id = :kiraId and n.agent.id = :agentId")
    void deleteAllByKiraIdAndAgentId(@Param("kiraId") Long kiraId, @Param("agentId") Long agentId);

    News findById(long id);

    News findTopByOrderByIdDesc();

    @Query("select count(n) from News n where n.kira.id = :kiraId and n.agent.id = :agentId")
    long cntNewsByKiraAndAgent(@Param("kiraId") long kiraId, @Param("agentId") long agentId);

}