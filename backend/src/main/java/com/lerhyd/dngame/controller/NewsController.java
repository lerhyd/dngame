package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.generators.NewsGenerator;
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

    @PostMapping("/game/news/add")
    public int addNews(@RequestBody NewsReq newsReq){
        if (agentDao.getOne(newsReq.getAgentId()) == null)
            return 1;
        if (agentDao.getOne(newsReq.getAgentId()).getUser() == null)
            return 2;
        if (agentDao.getOne(newsReq.getAgentId()).getUser().getProfile() == null)
            return 3;
        if (kiraDao.getOne(newsReq.getKiraId()) == null)
            return 4;
        if (agentDao.getOne(newsReq.getAgentId()).getNews().get(0).getKira() == null)
            return 5;
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

    @GetMapping("/game/kira/news/get")
    public Stream<NewsInfo> getNewsByKira(@RequestParam("id") int kiraId){
        Region homeRegion = kiraDao.findById(kiraId).getRegion();
        int agentId = kiraDao.findById(kiraId).getNews().get(0).getAgent().getId();
        while (true){
            List<News> newsList = newsDao.findNotPublishedNewsByKiraIdAndAgentId(kiraId, agentId);

            for (News news: newsList){
                if (news.getPublicationDate().isBefore(LocalDateTime.now()) || news.getPublicationDate().isEqual(LocalDateTime.now())){
                    if (checkIfNewsCouldBeSeen(news, homeRegion)){
                        news.setPublished(true);
                        newsDao.save(news);
                        return Stream.of(news).map(NewsInfo::new);
                    }
                }
            }
        }
    }

    @GetMapping("/game/agent/news/get")
    public Stream<NewsInfo> getNewsByAgent(@RequestParam("id") int agentId){
        Region homeRegion = agentDao.findById(agentId).getRegion();
        int kiraId = agentDao.findById(agentId).getNews().get(0).getAgent().getId();
        while (true){
            List<News> newsList = newsDao.findNotPublishedNewsByKiraIdAndAgentId(kiraId, agentId);
            for (News news: newsList){
                if (news.getPublicationDate().isBefore(LocalDateTime.now()) || news.getPublicationDate().isEqual(LocalDateTime.now())){
                    news.setPublished(true);
                    newsDao.save(news);
                    NewsGenerator.generateRandomNews(kiraId, agentId, newsDao, kiraDao, agentDao, personDao, regionDao);
                    return Stream.of(news).map(NewsInfo::new);
                }
            }
        }
    }

    private boolean checkIfNewsCouldBeSeen(News news, Region homeRegion){

        if (homeRegion.getPlanet().equals(news.getDistributionRegion().getPlanet()))
            if (news.getDistributionRegion().getContinent() == null)
                if (news.getDistributionRegion().getCountry() == null)
                    if (news.getDistributionRegion().getCity() == null)
                        return true;
        if (homeRegion.getPlanet().equals(news.getDistributionRegion().getPlanet()))
            if (homeRegion.getContinent().equals(news.getDistributionRegion().getContinent()))
                if (news.getDistributionRegion().getCountry() == null)
                    if (news.getDistributionRegion().getCity() == null)
                        return true;
        if (homeRegion.getPlanet().equals(news.getDistributionRegion().getPlanet()))
            if (homeRegion.getContinent().equals(news.getDistributionRegion().getContinent()))
                if (homeRegion.getCountry().equals(news.getDistributionRegion().getCountry()))
                    if (news.getDistributionRegion().getCity() == null)
                        return true;
        if (homeRegion.getId() == news.getDistributionRegion().getId())
                        return true;
        return false;
    }

}
