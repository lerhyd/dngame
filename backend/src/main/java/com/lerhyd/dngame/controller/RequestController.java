package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.RequestInfo;
import com.lerhyd.dngame.model.*;
import com.lerhyd.dngame.request.RequestReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
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

    @Autowired
    private RankDao rankDao;

    @Autowired
    private AchievementDao achievementDao;

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
        int kiraIdToCheck = agentDao.getOne(requestReq.getAgentId()).getNews().get(0).getKira().getId();
        if (newsDao.cntVictimsThatUsedInNews(kiraIdToCheck, requestReq.getAgentId())==personDao.cntAllPersonsWithoutFake())
            return 6;
        boolean isRequestPersonExists = requestDao.existsRequestByCrimePerson_NameAndCrimePerson_SurnameAndCrimePerson_PatronymicAndCrimePerson_Sex(
            requestReq.getPersonName(),
            requestReq.getPersonSurname(),
            requestReq.getPersonPatr(),
            requestReq.isPersonSex()
        );

        if (isRequestPersonExists)
            return 7;

        boolean isPersonExists = personDao.existsByNameAndSurnameAndPatronymicAndSex(
                requestReq.getPersonName(),
                requestReq.getPersonSurname(),
                requestReq.getPersonPatr(),
                requestReq.isPersonSex()
        );
        if (!isPersonExists) {
            return 8;
        } else {
            agentDao.deletePoints(5, requestReq.getAgentId());//value of police request
            Request request = new Request();
            Person guiltyPerson = personDao.findByNameAndSurnameAndPatronymicAndSex(
                    requestReq.getPersonName(),
                    requestReq.getPersonSurname(),
                    requestReq.getPersonPatr(),
                    requestReq.isPersonSex());
            if (!guiltyPerson.isCriminal() || guiltyPerson.isFake()){
                deletePointsOfAgent(requestReq.getAgentId(),10);//penalty for mistake
                request.setSuccess(false);
            } else {
                addPointsOfAgent(requestReq.getAgentId(),15);//reward for correctness
                request.setSuccess(true);
                addNumberOfCaughtKillers(requestReq.getAgentId());
            }
            request.setAgent(agentDao.getOne(requestReq.getAgentId()));
            request.setCrimePerson(guiltyPerson);
            request.setAction(actionDao.getOne(policeActionId));
            requestDao.save(request);
            newsDao.save(generateNewsFromRequest(request));

            int points = agentDao.findPointsById(requestReq.getAgentId());
            if (points < 0)
                return 9;//Kira wins

            Agent agent = agentDao.getOne(requestReq.getAgentId());
            if (agent.getNumberOfCaughtKillers() >= 3){
                if (agent.getNumberOfCaughtKillers() > 30)
                    agent.setLvl(11);
                agent.setLvl(agent.getNumberOfCaughtKillers()/3);
            }
            agentDao.save(agent);
            setRankToAgent(requestReq.getAgentId());
        }

    //Welcome ach
        Achievement welcomeAch = achievementDao.getOne("Welcome");
        if (!agentDao.getOne(requestReq.getAgentId()).getAchievements().contains(welcomeAch))
            if (agentDao.getOne(requestReq.getAgentId()).getLvl() == 1){
                Agent agentToSave = agentDao.getOne(requestReq.getAgentId());
                if (agentToSave.getAchievements() == null) {
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }

                agentToSave.getAchievements().add(welcomeAch);
                agentDao.save(agentToSave);
            }
        return 0;
    }

    private void addPointsOfAgent(int agentId, int points){
        Agent agentToSave = agentDao.getOne(agentId);
        agentToSave.setPoints(agentToSave.getPoints() + points);
        agentDao.save(agentToSave);
    }

    private void deletePointsOfAgent(int agentId, int points){
        Agent agentToSave = agentDao.getOne(agentId);
        agentToSave.setPoints(agentToSave.getPoints() - points);
        agentDao.save(agentToSave);
    }

    private void addNumberOfCaughtKillers(int agentId){
        Agent agentToSave = agentDao.getOne(agentId);
        agentToSave.setNumberOfCaughtKillers(agentToSave.getNumberOfCaughtKillers() + 1);
        agentDao.save(agentToSave);
    }

    private boolean setRankToAgent(int agentId){
        Agent agent = agentDao.getOne(agentId);
        boolean isDone = false;

        isDone = setAgentRankInRange(agent, 30, 40, 9);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 40, 50, 10);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 50, 60, 11);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 60, 80, 12);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 80, 100, 13);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 100, 170, 14);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 170, 256, 15);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 256, 0, 16);
        if (isDone)
            return true;
        return false;

    }

    private boolean setAgentRankInRange(Agent agent, int from, int to, int rankNum){
        if (to != 0){
            if (agent.getPoints() <= 30)
                return true;
            if (agent.getPoints() >= from && agent.getPoints() < to){
                if (agent.getRank().getId() > rankDao.findRankByClassAndId(false, rankNum).getId())
                    return true;
                agent.setRank(rankDao.findRankByClassAndId(false, rankNum));
            } else
                return false;
        } else {
            if (agent.getPoints() >= from) {
                if (agent.getRank().getId() > rankDao.findRankByClassAndId(false, rankNum).getId())
                    return true;
                agent.setRank(rankDao.findRankByClassAndId(false, rankNum));
            } else
                return false;
        }

        agentDao.save(agent);
        return true;
    }

    private News generateNewsFromRequest(Request request){
        News news = new News();
        news.setPublishedForKira(false);
        news.setPublishedForAgent(false);
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
        news.setGuiltyPersonExists(true);
        news.setVictim(null);
        news.setDescription("Police Department News");
        return news;
    }
}
