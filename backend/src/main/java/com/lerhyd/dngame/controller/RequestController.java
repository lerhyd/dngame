package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.RequestInfo;
import com.lerhyd.dngame.model.Agent;
import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import com.lerhyd.dngame.model.Request;
import com.lerhyd.dngame.request.RequestReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@RestController
public class RequestController {

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private RegionDao regionDao;

    @Autowired
    private NewsDao newsDao;

    private final int policeActionId = 1;
    private final int worldRegionId = 1;

    @GetMapping("/game/request")
    public Stream<RequestInfo> getRequests(@RequestParam("agentId") int agentId){
        return requestDao.findAllByAgent_Id(agentId).stream().map(RequestInfo::new);
    }

    @PostMapping("/game/request/add")
    public int addRequest(@RequestBody RequestReq requestReq){
        int requestCount = requestDao.findCntOfRequestInOnePage(requestReq.getAgentId(), requestReq.getPageNum());
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
            agentDao.deletePoints(5, requestReq.getAgentId());//value of police request
            Request request = new Request();
            Person guiltyPerson = personDao.findByNameAndSurnameAndPatronymicAndSex(
                    requestReq.getPersonName(),
                    requestReq.getPersonSername(),
                    requestReq.getPersonPatr(),
                    requestReq.isPersonSex());
            if (!guiltyPerson.isCriminal() || guiltyPerson.isFake()){
                agentDao.deletePoints(10, requestReq.getAgentId());//penalty for mistake
                request.setSuccess(false);
            } else {
                agentDao.addPoints(15, requestReq.getAgentId());//reward for correctness
                request.setSuccess(true);
            }
            request.setAgent(agentDao.getOne(requestReq.getAgentId()));
            request.setCrimePerson(guiltyPerson);
            request.setAction(actionDao.getOne(policeActionId));
            requestDao.save(request);
            newsDao.save(generateNewsFromRequest(request));

            int points = agentDao.findPointsById(requestReq.getAgentId());
            if (points < 0)
                return 8;//Kira wins
        }

        return 0;
    }

    private News generateNewsFromRequest(Request request){
        News news = new News();
        news.setPublished(false);
        news.setAgentGenerated(false);
        news.setDistributionRegion(regionDao.findById(worldRegionId));
        news.setAction(request.getAction());
        news.setGuiltyPerson(request.getCrimePerson());
        news.setCommonRegion(request.getCrimeRegion());
        news.setPublicationDate(LocalDateTime.now().plusSeconds(50));
        news.setAgent(request.getAgent());
        news.setKira(request.getAgent().getNews().get(0).getKira());
        news.setDie(false);
        news.setFake(false);
        news.setVictimExists(false);
        news.setVictim(null);
        news.setDescription("Police Department News");
        return news;
    }
}
