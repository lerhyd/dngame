package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.NewsInfo;
import com.lerhyd.dngame.model.News;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        boolean victimExists = personDao.getOne(newsReq.getVictimId()) != null ? true : false;
        News news = new News(victimExists,
                newsReq.getDesc(),
                LocalDateTime.parse(newsReq.getPubDate(), formatter),
                    actionDao.findById(newsReq.getActionId()),
                    actionPlaceDao.findById(newsReq.getActionPlaceId()),
                    personDao.findById(newsReq.getVictimId()),
                    agentDao.findById(newsReq.getAgentId()),
                    kiraDao.findById(newsReq.getKiraId()),
                    regionDao.findById(newsReq.getDistRegionId()),
                    regionDao.findById(newsReq.getCommonRegionId()),
                    personDao.findById(newsReq.getGuiltyPersonId())
                );

        newsDao.save(news);
        return 0;
    }

    /**
     * Get the last news
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent} who is the part of current session
     * @param kiraId id of {@link com.lerhyd.dngame.model.Kira} who is the part of current session
     * @return Stream of news info
     */
    @GetMapping("/news/get")
    public Stream<NewsInfo> getNewsToPublish(@RequestParam("kiraId") long kiraId, @RequestParam("agentId") long agentId){
        return newsDao.findAllNewsByAgent_IdAndKira_Id(kiraId, agentId).stream().map(NewsInfo::new);
    }

    /**
     * delete all the news in the world
     * @param kiraId id of {@link com.lerhyd.dngame.model.Kira}
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent}
     */
    @DeleteMapping("/news/delete")
    public void deleteNews(@RequestParam("kiraId") long kiraId, @RequestParam("agentId") long agentId){
        newsDao.deleteAllByKiraIdAndAgentId(kiraId, agentId);
    }

}
