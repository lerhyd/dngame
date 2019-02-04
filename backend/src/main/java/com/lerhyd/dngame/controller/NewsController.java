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
    public void addNews(@RequestBody NewsReq newsReq){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        News news = new News(newsReq.getDesc(),
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
