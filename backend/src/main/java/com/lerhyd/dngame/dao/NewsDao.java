package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface NewsDao extends JpaRepository<News, Integer> {

    @Query("select n from News n where n.kira.id=:kiraId and n.agent.id = :agentId")
    List<News> findAllByKiraAndAgent(@Param("kiraId") int kiraId, @Param("agentId") int agentId);

    @Query("select n from News n where n.kira.id=:kiraId")
    List<News> findAllNewsByKiraId(@Param("kiraId") int kiraId);

    @Query("select n from News n where n.agent.id=:agentId")
    List<News> findAllNewsByAgentId(@Param("agentId") int agentId);

    @Transactional
    @Modifying
    void deleteAllByKira_Id(int kiraId);

    @Transactional
    @Modifying
    void deleteAllByAgent_Id(int agentId);

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

    @Query("select (count(n) > 0) from News n where n.victim.id=:victimId and n.agent.id=:agentId and n.kira.id=:kiraId")
    boolean checkIfNewsVictimExists(@Param("agentId") int agentId, @Param("kiraId") int kiraId, @Param("victimId") int victimId);

    @Query("select (count(n) > 0) from News n where n.guiltyPerson.id=:guiltyPersonId and n.agent.id=:agentId and n.kira.id=:kiraId")
    boolean checkIfNewsGuiltyPersonExists(@Param("agentId") int agentId, @Param("kiraId") int kiraId, @Param("guiltyPersonId") int guiltyPersonId);

    @Query("select count(n) from News n left join  n.victim v where v.fake=false and n.agent.id=:agentId and n.kira.id=:kiraId and n.die=true")
    int cntVictimsThatUsedInNews(@Param("agentId") int agentId, @Param("kiraId") int kiraId);

    @Query("select n.die from News n where n.victim.id=:victimId and n.agent.id=:agentId and n.kira.id=:kiraId")
    Optional<Boolean> checkIfVictimDiedInNews(@Param("agentId") int agentId, @Param("kiraId") int kiraId, @Param("victimId") int victimId);

    @Query("select (count(n) > 0) from News n where n.kira.id = :kiraId and n.agent.id =:agentId " +
            "and n.publicationDate is not null and n.publishedForKira = false and n.publishedForAgent = false and n.fromEntry = false")
    Boolean isThereNewNews(@Param("agentId") int agentId, @Param("kiraId") int kiraId);
}