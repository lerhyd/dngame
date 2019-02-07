package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.generators.NewsGenerator;
import com.lerhyd.dngame.model.*;
import com.lerhyd.dngame.request.PersonReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@SuppressWarnings("Duplicates")
@RestController
public class MainController {

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private RankDao rankDao;

    @Autowired
    private RegionDao regionDao;

    @PostMapping("/game/profile/create")
    public int createProfile(@RequestBody PersonReq personReq){
        User u = userDao.getOne(personReq.getUserLogin());
        Person personToCheck = u.getProfile();
        if (personToCheck != null)
            return 1;
        if (personDao.existsByNameAndSurnameAndPatronymicAndSex(personReq.getName(),
                                                                personReq.getSurname(),
                                                                personReq.getPatr(),
                                                                personReq.isSex()))
            return 2;
        Person p = new Person();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        p.setName(personReq.getName());
        p.setSurname(personReq.getSurname());
        p.setPatronymic(personReq.getPatr());
        p.setDeathDate(null);
        p.setBornDate(LocalDateTime.parse(personReq.getBornDate(), formatter));
        p.setSex(personReq.isSex());
        p.setFake(false);
        p.setCriminal(false);
        u.setProfile(p);
        personDao.save(p);
        userDao.save(u);
        return 0;
    }

    @PostMapping("/game/profile/delete")
    public int deleteProfile(@RequestParam("profileId") int profileId){
        if (personDao.getOne(profileId) == null)
            return 1;
        User user = userDao.findUserByProfile(profileId);
        user.setProfile(null);
        userDao.save(user);
        personDao.deleteById(profileId);
        return 0;
    }

    @PostMapping("/game/class/choose")
    public int setMainClass(@RequestParam("isKira") boolean isKira,
                             @RequestParam("userLogin") String userLogin,
                             @RequestParam("regionId") int regionId){
        if (userDao.getOne(userLogin) == null)
            return 1;
        User u = userDao.getOne(userLogin);
        if (u.getProfile() == null)
            return 2;
        if (isKira){
            Kira k;
            if (u.getKira() != null)
                k = kiraDao.getOne(u.getKira().getId());
            else {
                k = new Kira();
                k.setNumberOfLoses(0);
                k.setNumberOfWins(0);
            }
            k.setNumberOfKills(0);
            k.setPoints(30);
            k.setLvl(0);
            k.setUser(u);
            k.setNews(null);
            k.setRank(rankDao.findByPoints(k.getPoints(), true));
            k.setRegion(regionDao.findById(regionId));
            u.setKira(k);
            kiraDao.save(k);
            userDao.save(u);
            findOpponent(isKira, k.getId());
        } else {
            Agent a;
            if (u.getAgent() != null)
                a = agentDao.getOne(u.getAgent().getId());
            else{
                a = new Agent();
                a.setNumberOfLoses(0);
                a.setNumberOfWins(0);
            }
            a.setNumberOfCaughtKillers(0);
            a.setPoints(30);
            a.setLvl(0);
            a.setUser(u);
            a.setNews(null);
            a.setRank(rankDao.findByPoints(a.getPoints(), false));
            a.setRegion(regionDao.findById(regionId));
            u.setAgent(a);
            agentDao.save(a);
            userDao.save(u);
            findOpponent(isKira, a.getId());
        }
        return 0;
    }

    public void findOpponent(boolean isKira, int classId){
        boolean isFound = false;

        while (!isFound){
            if (isKira){
                List<Agent> agents = agentDao.findAgentsWithoutNews();
                if (isMatchCreated(isKira, classId))
                    break;

                if (!agents.isEmpty()){
                    Kira kira = kiraDao.findById(classId);
                    Agent agent = agents.get(0);
                    createMatch(kira.getId(), agent.getId());
                    isFound = true;
                }
            } else {
                List<Kira> kiras = kiraDao.findKirasWithoutNews();

                if (isMatchCreated(isKira, classId))
                    break;

                if (!kiras.isEmpty()){
                    Agent agent = agentDao.findById(classId);
                    Kira kira = kiras.get(0);
                    createMatch(kira.getId(), agent.getId());
                    isFound = true;
                }

            }

        }
    }

    public void createMatch(int kiraId, int agentId){
        News news = new News();
        Kira kira = kiraDao.findById(kiraId);
        Agent agent = agentDao.findById(agentId);
        news.setKira(kira);
        news.setAgent(agent);
        news.setDescription(kira.getUser().getLogin() + " and " + agent.getUser().getLogin() + " has been connected");
        news.setAgentGenerated(false);
        newsDao.save(news);
        List<News> newsList = newsDao.findAllByKiraAndAgent(kiraId, agentId);
        kira.setNews(newsList);
        agent.setNews(newsList);
        kiraDao.save(kira);
        agentDao.save(agent);
    }

    public boolean isMatchCreated(boolean isKira, int classId){
        if (isKira){
            return kiraDao.existsWithNewsByKiraId(classId);
        } else {
            return agentDao.existsWithNewsByAgentId(classId);
        }
    }



}
