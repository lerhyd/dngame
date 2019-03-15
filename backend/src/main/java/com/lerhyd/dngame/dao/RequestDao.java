package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestDao extends JpaRepository<Request, Integer> {

    List<Request> findAllByAgent_Id(int agentId);

    @Query("select count(r) from Request r where r.agent.id =:agentId and r.pageNumber=:pageNumber")
    int findCntOfRequestInOnePage(@Param("agentId") int agentId, @Param("pageNumber") int pageNumber);

    boolean existsRequestByCrimePerson_NameAndCrimePerson_SurnameAndCrimePerson_PatronymicAndCrimePerson_Sex(String name,
                                                                                       String surname,
                                                                                       String patr,
                                                                                       boolean sex);

    @Query("select max(r.pageNumber) from Request r where r.agent.id = :agentId")
    Optional<Integer> findMaxNumPageByAgentId(@Param("agentId") int agentId);
}
