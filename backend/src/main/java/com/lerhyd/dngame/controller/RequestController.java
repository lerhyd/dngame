package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.ActionDao;
import com.lerhyd.dngame.dao.AgentDao;
import com.lerhyd.dngame.dao.PersonDao;
import com.lerhyd.dngame.dao.RequestDao;
import com.lerhyd.dngame.info.RequestInfo;
import com.lerhyd.dngame.model.Agent;
import com.lerhyd.dngame.model.Person;
import com.lerhyd.dngame.model.Request;
import com.lerhyd.dngame.request.RequestReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
public class RequestController {

    @Autowired
    RequestDao requestDao;

    @Autowired
    AgentDao agentDao;

    @Autowired
    PersonDao personDao;

    @Autowired
    ActionDao actionDao;

    @GetMapping("/game/request")
    public Stream<RequestInfo> getRequests(@RequestParam("agentId") long agentId){
        return requestDao.findAllByAgent_Id(agentId).stream().map(RequestInfo::new);
    }

    @PostMapping("/game/request/add")
    public int addRequest(@RequestBody RequestReq requestReq){
        long requestCount = requestDao.findCntOfRequestInOnePage(requestReq.getAgentId(), requestReq.getPageNum());
        if (requestCount == 10)
            return 1;
        int maxPageNum = requestDao.findMaxNumPageByAgentId(requestReq.getAgentId()).orElse(1);
        if ((requestReq.getPageNum() - 1) > maxPageNum)
            return 2;
        if (!agentDao.existsById(requestReq.getAgentId())){
            return 3;
        }
        if (agentDao.getOne(requestReq.getAgentId()).getUser().getProfile() == null)
            return 4;

        if (agentDao.getOne(requestReq.getAgentId()).getNews().get(0) == null)
            return 5;
        boolean isRequestPersonExists = requestDao.existsRequestByCrimePerson_NameAndCrimePerson_SurnameAndCrimePerson_PatronymicAndCrimePerson_Sex(
            requestReq.getPersonName(),
            requestReq.getPersonSername(),
            requestReq.getPersonPatr(),
            requestReq.isPersonSex()
        );

        if (isRequestPersonExists)
            return 6;

        boolean isPersonExists = personDao.existsByNameAndSurnameAndPatronymicAndSex(
                requestReq.getPersonName(),
                requestReq.getPersonSername(),
                requestReq.getPersonPatr(),
                requestReq.isPersonSex()
        );
        if (!isPersonExists) {
            return 7;
        } else {
            Agent agent = agentDao.getOne(requestReq.getAgentId());
            agent.setPoints(agent.getPoints() - 5);//value of police request
            Request request = new Request();
            Person guiltyPerson = personDao.findByNameAndSurnameAndPatronymicAndSex(
                    requestReq.getPersonName(),
                    requestReq.getPersonSername(),
                    requestReq.getPersonPatr(),
                    requestReq.isPersonSex());
            if (guiltyPerson.isCriminal() || guiltyPerson.isFake()){
                agent.setPoints(agent.getPoints() - 10);//penalty for mistake
            } else {
                agent.setPoints(agent.getPoints() + 15);//reward for correctness
            }
            request.setAgent(agentDao.getOne(requestReq.getAgentId()));
            request.setCrimePerson(guiltyPerson);
            request.setAction(actionDao.getOne(Long.valueOf(1)));
            requestDao.save(request);
            agentDao.save(agent);
            if (agent.getPoints() < 0)
                return 8;//Kira wins
        }

        return 0;
    }
}
