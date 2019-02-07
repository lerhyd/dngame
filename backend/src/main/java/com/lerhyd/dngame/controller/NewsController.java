package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.NewsInfo;
import com.lerhyd.dngame.model.Agent;
import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import com.lerhyd.dngame.request.NewsReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@RestController()
public class NewsController {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private ActionPlaceDao actionPlaceDao;

    @Autowired
    private RegionDao regionDao;

    @Autowired
    private PersonDao personDao;

    @PostMapping("/news/add")
    public int addNews(@RequestBody NewsReq newsReq){
        if (agentDao.getOne(newsReq.getAgentId()) == null)
            return 1;
        if (agentDao.getOne(newsReq.getAgentId()).getUser() == null)
            return 2;
        if (agentDao.getOne(newsReq.getAgentId()).getUser().getProfile() == null)
            return 3;
        if (agentDao.getOne(newsReq.getAgentId()).getNews().get(0).getKira() == null)
            return 4;
        agentDao.deletePoints(40, newsReq.getAgentId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        boolean victimExists = personDao.getOne(newsReq.getVictimId()) != null ? true : false;
        Person victim = null;
        if (victimExists){
            victim = personDao.findById(newsReq.getVictimId());
        }
        News news = new News(victimExists,
                true,
                true,
                newsReq.isDie(),
                newsReq.getDesc(),
                LocalDateTime.parse(newsReq.getPubDate(), formatter),
                    actionDao.findById(newsReq.getActionId()),
                    actionPlaceDao.findById(newsReq.getActionPlaceId()),
                    victim,
                    agentDao.findById(newsReq.getAgentId()),
                    kiraDao.findById(newsReq.getKiraId()),
                    regionDao.findById(newsReq.getDistRegionId()),
                    regionDao.findById(newsReq.getCommonRegionId()),
                    personDao.findById(newsReq.getGuiltyPersonId())
                );

        newsDao.save(news);
        int points = agentDao.findPointsById(newsReq.getAgentId());
        if (points < 0)
            return 5;//kira wins
        return 0;
    }

    /**
     * Get the last news
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent} who is the part of current session
     * @param kiraId id of {@link com.lerhyd.dngame.model.Kira} who is the part of current session
     * @return Stream of news info
     */
    @GetMapping("/news/get")
    public Stream<NewsInfo> getNewsToPublish(@RequestParam("kiraId") int kiraId, @RequestParam("agentId") int agentId){
        return newsDao.findAllNewsByAgent_IdAndKira_Id(kiraId, agentId).stream().map(NewsInfo::new);
    }

    /**
     * delete all the news in the world
     * @param kiraId id of {@link com.lerhyd.dngame.model.Kira}
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent}
     */
    @DeleteMapping("/news/delete")
    public void deleteNews(@RequestParam("kiraId") int kiraId, @RequestParam("agentId") int agentId){
        newsDao.deleteAllByKiraIdAndAgentId(kiraId, agentId);
    }

}
