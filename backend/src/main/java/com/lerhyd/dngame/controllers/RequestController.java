package com.lerhyd.dngame.controllers;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.RequestInfo;
import com.lerhyd.dngame.model.*;
import com.lerhyd.dngame.request.RequestReq;
import com.lerhyd.dngame.services.EmailService;
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

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserDao userDao;

    private final int policeActionId = 1;
    private final int worldRegionId = 1;

    /**
     * Get note's pages
     * @param userLogin ID of user.
     * @return Number of pages.
     */
    @GetMapping("/game/request/pages")
    public List<Integer> getRequestPages(@RequestParam("userLogin") String userLogin){
        int agentId = userDao.getOne(userLogin).getAgent().getId();
        int maxNum = requestDao.findMaxNumPageByAgentId(agentId).orElse(1) + 1;
        List<Integer> listOfNums = new ArrayList<>();
        for (int i = 1; i<maxNum; i++){
            listOfNums.add(i);
        }
        return listOfNums;
    }

    /**
     * Get all requests by Agent.
     * @param userLogin ID of the user.
     * @return Stream of request info.
     */
    @GetMapping("/game/request")
    public Stream<RequestInfo> getRequests(@RequestParam("userLogin") String userLogin, @RequestParam("numPage") int numPage){
        int agentId = userDao.getOne(userLogin).getAgent().getId();
        return requestDao.findAllByAgent(agentId, numPage).stream().map(RequestInfo::new);
    }

    /**
     * Add request by Agent.
     * @param requestReq Form of the request.
     * @return Status:
     * 3 -- Agent with the ID does not exist,
     * 4 -- Current user does not have profile,
     * 5 -- There's no match with the Agent's ID,
     * 6 -- These's no alive victims,
     * 7 -- The request with the person already exists,
     * 8 -- There's no person with the identification data,
     * 9 -- The Kira won because the Agent's points less than 0,
     * 0 -- The function was executed correctly,
     * 666 -- The Agent won because he has 300 points or more.
     */
    @PostMapping("/game/request/add")
    public int addRequest(@RequestBody RequestReq requestReq){
        int numPage;
        int agentId = userDao.getOne(requestReq.getUserLogin()).getAgent().getId();
        int maxNumPage = requestDao.findMaxNumPageByAgentId(agentId).orElse(0);
        if (maxNumPage == 0)
            numPage = 1;
        else
            numPage = maxNumPage;
        int requestCount = requestDao.findCntOfRequestInOnePage(agentId, numPage);
        if (requestCount == 5)
            numPage++;

        if (!agentDao.existsById(agentId)){
            return 3;
        }

        if (agentDao.getOne(agentId).getUser().getProfile() == null)
            return 4;

        if (agentDao.getOne(agentId).getNews().get(0) == null)
            return 5;

        int kiraIdToCheck = agentDao.getOne(agentId).getNews().get(0).getKira().getId();
        if (newsDao.cntVictimsThatUsedInNews(kiraIdToCheck, agentId)==personDao.cntAllPersonsWithoutFake())
            return 6;

        agentDao.deletePoints(5, agentId);//value of police request

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
            deletePointsOfAgent(agentId,5);
            return 8;
        } else {

            Request request = new Request();
            Person guiltyPerson = personDao.findByNameAndSurnameAndPatronymicAndSex(
                    requestReq.getPersonName(),
                    requestReq.getPersonSurname(),
                    requestReq.getPersonPatr(),
                    requestReq.isPersonSex());
            if (!guiltyPerson.isCriminal() || guiltyPerson.isFake()){
                deletePointsOfAgent(agentId,10);//penalty for mistake
                request.setSuccess(false);
            } else {
                addPointsOfAgent(agentId,15);//reward for correctness
                request.setSuccess(true);
                addNumberOfCaughtKillers(agentId);
            }
            request.setAgent(agentDao.getOne(agentId));
            request.setCrimePerson(guiltyPerson);
            request.setAction(actionDao.getOne(policeActionId));
            requestDao.save(request);
            newsDao.save(generateNewsFromRequest(request));

            int points = agentDao.findPointsById(agentId);
            if (points >= 300)
                return 666;//agent won
            if (points < 0)
                return 9;//kira won

            Agent agent = agentDao.getOne(agentId);
            if (agent.getNumberOfCaughtKillers() >= 3){
                if (agent.getNumberOfCaughtKillers() > 30)
                    agent.setLvl(11);
                agent.setLvl(agent.getNumberOfCaughtKillers()/3);
            }
            agentDao.save(agent);
            setRankToAgent(agentId);
        }

        //Welcome ach
        Achievement welcomeAch = achievementDao.getOne("Welcome");
        if (!agentDao.getOne(agentId).getAchievements().contains(welcomeAch))
            if (agentDao.getOne(agentId).getLvl() == 1){
                Agent agentToSave = agentDao.getOne(agentId);
                if (agentToSave.getAchievements() == null) {
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }
                agentToSave.getAchievements().add(welcomeAch);
                agentDao.save(agentToSave);
                emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение Welcome.");
            }
        //Ad astra ach
        Achievement adAstraAch = achievementDao.getOne("Ad astra");
        if (!agentDao.getOne(agentId).getAchievements().contains(adAstraAch))
            if (agentDao.getOne(agentId).getLvl() == 5){
                Agent agentToSave = agentDao.getOne(agentId);
                if (agentToSave.getAchievements() == null) {
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }
                agentToSave.getAchievements().add(adAstraAch);
                agentDao.save(agentToSave);
                emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение Ad astra.");
            }
        //Welcome ach
        Achievement unstoppableAch = achievementDao.getOne("Unstoppable");
        if (!agentDao.getOne(agentId).getAchievements().contains(unstoppableAch))
            if (agentDao.getOne(agentId).getLvl() == 10){
                Agent agentToSave = agentDao.getOne(agentId);
                if (agentToSave.getAchievements() == null) {
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }
                agentToSave.getAchievements().add(unstoppableAch);
                agentDao.save(agentToSave);
                emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение Welcome.");
            }
        //Capital ach
        Achievement capitalAch = achievementDao.getOne("Capital");
        if (!agentDao.getOne(agentId).getAchievements().contains(capitalAch))
            if (agentDao.getOne(agentId).getPoints() >= 200){
                Agent agentToSave = agentDao.getOne(agentId);
                if (agentToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }
                agentToSave.getAchievements().add(capitalAch);
                agentDao.save(agentToSave);
                emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение Capital.");
            }
        //First invistigations ach
        Achievement firstInvistigationsAch = achievementDao.getOne("First invistigations");
        if (!agentDao.getOne(agentId).getAchievements().contains(firstInvistigationsAch))
            if (agentDao.getOne(agentId).getNumberOfCaughtKillers() == 10){
                Agent agentToSave = agentDao.getOne(agentId);
                if (agentToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }
                agentToSave.getAchievements().add(firstInvistigationsAch);
                agentDao.save(agentToSave);
                emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение First invistigations.");
            }
        //Path of righteousness ach
        Achievement pathOfRighteousnessAch = achievementDao.getOne("Path of righteousness");
        if (!agentDao.getOne(agentId).getAchievements().contains(pathOfRighteousnessAch))
            if (agentDao.getOne(agentId).getNumberOfCaughtKillers() == 20){
                Agent agentToSave = agentDao.getOne(agentId);
                if (agentToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }
                agentToSave.getAchievements().add(pathOfRighteousnessAch);
                agentDao.save(agentToSave);
                emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение Path of righteousness.");
            }
        //Uncontrollable detective ach
        Achievement uncontrollableDetectiveAch = achievementDao.getOne("Uncontrollable detective");
        if (!agentDao.getOne(agentId).getAchievements().contains(uncontrollableDetectiveAch))
            if (agentDao.getOne(agentId).getNumberOfWins() == 10){
                Agent agentToSave = agentDao.getOne(agentId);
                if (agentToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }
                agentToSave.getAchievements().add(uncontrollableDetectiveAch);
                agentDao.save(agentToSave);
                emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение Uncontrollable detective.");
            }
        //Irrepressible detective ach
        Achievement irrepressibleDetective = achievementDao.getOne("Irrepressible detective");
        if (!agentDao.getOne(agentId).getAchievements().contains(irrepressibleDetective))
            if (agentDao.getOne(agentId).getNumberOfWins() == 20){
                Agent agentToSave = agentDao.getOne(agentId);
                if (agentToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    agentToSave.setAchievements(achievements);
                }
                agentToSave.getAchievements().add(irrepressibleDetective);
                agentDao.save(agentToSave);
                emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение Irrepressible detective.");
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
