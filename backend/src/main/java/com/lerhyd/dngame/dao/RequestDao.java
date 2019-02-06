package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestDao extends JpaRepository<Request, Long> {

    List<Request> findAllByAgent_Id(long agentId);

    @Query("select count(r) from Request r where r.agent.id =:agentId and r.pageNum=:pageNum")
    int findCntOfRequestInOnePage(@Param("agentId") long agentId, @Param("pageNum") int pageNum);

    @Query("select max(r.pageNumber) from Request r where r.agent.id = :agentd")
    Optional<Integer> findMaxNumPageByAgentId(@Param("agentId") long agentId);

    boolean existsRequestByCrimePerson_NameAndCrimePerson_SurnameAndCrimePerson_PatronymicAndCrimePerson_Sex(String name,
                                                                                       String surname,
                                                                                       String patr,
                                                                                       boolean sex);

}
