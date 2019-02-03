package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.model.Agent;
import com.lerhyd.dngame.model.Kira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("Duplicates")
@RestController
public class KiraController {

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private RankDao rankDao;

    @PostMapping("game/kira/win")
    public int endGame(@RequestParam long id){
        Kira k = kiraDao.getOne(id);
        long agentId = k.getNews().get(0).getAgent().getId();
        Agent a = agentDao.getOne(agentId);

        newsDao.deleteAllByKiraIdAndAgentId(id, agentId);
        personDao.deleteAllByFake();
        entryDao.deleteAllByKiraId(id);

        k.setLvl(0);
        k.setPoints(0);
        k.setNumberOfKills(0);
        k.setEntries(null);
        k.setNews(null);
        k.setRank(rankDao.findByLvl(0));

        a.setLvl(0);
        a.setPoints(0);
        a.setNumberOfCaughtKillers(0);
        a.setNews(null);
        a.setRank(rankDao.findByLvl(0));

        k.setNumberOfWins(k.getNumberOfWins() + 1);
        a.setNumberOfLoses(a.getNumberOfLoses() + 1);

        kiraDao.save(k);
        agentDao.save(a);
        return 0;
    }

}
