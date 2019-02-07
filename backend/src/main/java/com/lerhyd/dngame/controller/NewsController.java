package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.NewsInfo;
import com.lerhyd.dngame.model.Agent;
import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import com.lerhyd.dngame.model.Region;
import com.lerhyd.dngame.request.NewsReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
@RestController
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
        News news = new News(false, victimExists,
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

    @GetMapping("game/kira/news/get")
    public Stream<NewsInfo> getNewsByKira(@RequestParam("kiraId") int kiraId){
        Region homeRegion = kiraDao.findById(kiraId).getRegion();
        int agentId = kiraDao.findById(kiraId).getNews().get(0).getAgent().getId();
        while (true){
            List<News> newsList = newsDao.findAllNotPublishedByKiraIdAndAgentId(kiraId, agentId);

            for (News news: newsList){
                if (news.getPublicationDate().isBefore(LocalDateTime.now())){

                        
                        news.setPublished(true);
                        newsDao.save(news);
                        return Stream.of(news).map(NewsInfo::new);
                }
            }
        }
    }

    @GetMapping("game/agent/news/get")
    public Stream<NewsInfo> getNewsByAgent(@RequestParam("agentId") int agentId){
        Region homeRegion = agentDao.findById(agentId).getRegion();
        int kiraId = agentDao.findById(agentId).getNews().get(0).getAgent().getId();
        while (true){
            List<News> newsList = newsDao.findAllNotPublishedByKiraIdAndAgentId(kiraId, agentId);
            for (News news: newsList){
                if (news.getPublicationDate().isBefore(LocalDateTime.now()))
                    if (homeRegion == news.getDistributionRegion())
                        news.setPublished(true);
                        newsDao.save(news);
                        return Stream.of(news).map(NewsInfo::new);
            }
        }
    }

    private boolean checkIfNewsCouldBeSeen(News news, Region homeRegion){
        boolean isPlanetCorrect = false;
        boolean isContinentCorrect = false;
        boolean isCountryCorrect = false;
        boolean isCityCorrect = false;
        if (homeRegion.getPlanet() == news.getDistributionRegion().getPlanet())
            if (homeRegion.getContinent() == null)
                if (homeRegion.getCountry() == null)
                    if (homeRegion.getCity() == null)
                        return true;

        return false;
    }

}
