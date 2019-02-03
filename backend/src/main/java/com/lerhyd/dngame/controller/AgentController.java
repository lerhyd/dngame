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
    private RankDao rankDao;

    @PostMapping("game/agent/win")
    public int endGame(@RequestParam long id){
        if (agentDao.findById(id).getLvl() <= 0)
            return 1;
        Agent a = agentDao.getOne(id);
        long kiraId = a.getNews().get(0).getKira().getId();
        Kira k = kiraDao.getOne(kiraId);

        newsDao.deleteAllByKiraIdAndAgentId(kiraId, id);
        personDao.deleteAllByFake();
        entryDao.deleteAllByKiraId(kiraId);

        a.setLvl(0);
        a.setPoints(0);
        a.setNumberOfCaughtKillers(0);
        a.setNews(null);
        a.setRank(rankDao.findByLvl(0));

        k.setLvl(0);
        k.setPoints(0);
        k.setNumberOfKills(0);
        k.setEntries(null);
        k.setNews(null);
        k.setRank(rankDao.findByLvl(0));

        a.setNumberOfWins(a.getNumberOfWins() + 1);
        k.setNumberOfLoses(k.getNumberOfLoses() + 1);

        agentDao.save(a);
        kiraDao.save(k);
        return 0;
    }

}
