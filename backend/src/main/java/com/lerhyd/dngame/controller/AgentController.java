package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.model.Achievement;
import com.lerhyd.dngame.model.Agent;
import com.lerhyd.dngame.model.Kira;
import com.lerhyd.dngame.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@RestController
public class AgentController {

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private AchievementDao achievementDao;

    @Autowired
    private EmailService emailService;

    @PostMapping("game/agent/win")
    public int endGame(@RequestParam int id){
        try {
            if (agentDao.getOne(id) == null)
                return 1;
            if (agentDao.getOne(id).getNews().get(0).getKira() == null)
                return 2;
            if (agentDao.getOne(id).getUser() == null)
                return 3;
            if (agentDao.getOne(id).getUser().getProfile() == null)
                return 4;
        } catch (IndexOutOfBoundsException e){
            return 5;
        }

        Agent a = agentDao.getOne(id);
        int kiraId = a.getNews().get(0).getKira().getId();
        Kira k = kiraDao.getOne(kiraId);

        newsDao.deleteAllByKiraIdAndAgentId(kiraId, id);
        personDao.deleteAllByFake();
        entryDao.deleteAllByKiraId(kiraId);

        a.setLvl(0);
        a.setPoints(0);
        a.setNumberOfCaughtKillers(0);
        a.setNews(null);
        a.setRank(null);
        a.setRequests(null);

        k.setLvl(0);
        k.setPoints(0);
        k.setNumberOfKills(0);
        k.setEntries(null);
        k.setNews(null);
        k.setRank(null);

        a.setNumberOfWins(a.getNumberOfWins() + 1);
        k.setNumberOfLoses(k.getNumberOfLoses() + 1);

        //First victory ach
        Achievement firstVictoryAch = achievementDao.getOne("Victory");
        if (!a.getAchievements().contains(firstVictoryAch))
            if (a.getNumberOfWins() == 1){
                if (a.getAchievements() == null) {
                    List<Achievement> achievements = new ArrayList<>();
                    a.setAchievements(achievements);
                }

                a.getAchievements().add(firstVictoryAch);
                emailService.sendMail("DN game.", agentDao.getOne(id).getUser(), "Вы получили достижение Victory.");
            }

        agentDao.save(a);
        kiraDao.save(k);
        return 0;
    }

}
