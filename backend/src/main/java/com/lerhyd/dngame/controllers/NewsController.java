package com.lerhyd.dngame.controllers;

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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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

    @Autowired
    private UserDao userDao;

    /**
     * Add news by Agent.
     * @param newsReq Form of the news from request.
     * @return Status:
     * 1 -- There's no Agent with the ID,
     * 2 -- There's no user with the ID,
     * 3 -- The user does not have profile,
     * 4 -- There's no Kira with the ID,
     * 5 -- There's no match between the Agent and the Kira,
     * 6 -- All persons were used in News,
     * 7 -- The Kira won because the Agent's points less than 0,
     * 666 -- The length of description is more than 50 symbols,
     * 0 -- The function was executed correctly.
     */
    @PostMapping("/game/news/add")
    public int addNews(@RequestBody NewsReq newsReq){

        int agentId = userDao.getOne(newsReq.getUserLogin()).getAgent().getId();
        int kiraId = userDao.getOne(newsReq.getUserLogin()).getAgent().getNews().get(0).getKira().getId();

        if (agentDao.getOne(agentId) == null)
            return 1;
        if (agentDao.getOne(agentId).getUser() == null)
            return 2;
        if (agentDao.getOne(agentId).getUser().getProfile() == null)
            return 3;
        if (kiraDao.getOne(agentId) == null)
            return 4;
        if (agentDao.getOne(agentId).getNews().get(0).getKira() == null)
            return 5;
        int kiraIdToCheck = agentDao.getOne(agentId).getNews().get(0).getKira().getId();
        if (newsDao.cntVictimsThatUsedInNews(kiraIdToCheck, agentId) == personDao.cntAllPersonsWithoutFake())
            return 6;
        if (newsReq.getDesc().length() > 50)
            return 666;
        if (newsReq.getPubDate() == "")
            return 444;
        Agent agentToSave = agentDao.getOne(agentId);
        agentToSave.setPoints(agentToSave.getPoints() - 40);
        agentDao.save(agentToSave);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        Instant dateInstant = Instant.from(formatter.parse(newsReq.getPubDate()));
        LocalDateTime pubDate = LocalDateTime.ofInstant(dateInstant, ZoneId.of(ZoneOffset.UTC.getId()));

        boolean guiltyPersonExists = personDao.getOne(newsReq.getGuiltyPersonId()) != null ? true : false;
        Person guiltyPerson = null;
        if (guiltyPersonExists){
            guiltyPerson = personDao.findById(newsReq.getVictimId());
        }
        News news = new News(
                false,
                false,
                false,
                guiltyPersonExists,
                true,
                true,
                false,
                newsReq.getDesc(),
                pubDate,
                actionDao.findById(newsReq.getActionId()),
                actionPlaceDao.findById(newsReq.getActionPlaceId()),
                guiltyPerson,
                agentDao.findById(agentId),
                kiraDao.findById(kiraId),
                regionDao.findById(newsReq.getDistRegionId()),
                regionDao.findById(newsReq.getCommonRegionId()),
                personDao.findById(newsReq.getGuiltyPersonId())
        );

        newsDao.save(news);
        int points = agentDao.findPointsById(agentId);
        if (points < 0)
            return 7;//kira wins
        return 0;
    }

    /**
     * Get news by Kira.
     * @param userLogin ID of the user.
     * @return Stream of news info.
     */
    @GetMapping("/game/kira/news/get")
    public Stream<NewsInfo> getNewsByKira(@RequestParam("userLogin") String userLogin){
        int kiraId = userDao.getOne(userLogin).getKira().getId();
        Region homeRegion = kiraDao.findById(kiraId).getRegion();
        int agentId = kiraDao.findById(kiraId).getNews().get(0).getAgent().getId();
        while (true){
            List<News> newsList = newsDao.findNotPublishedNewsForKiraByKiraIdAndAgentId(kiraId, agentId);
            for (News news: newsList){
                if (news.getPublicationDate().isBefore(LocalDateTime.now()) || news.getPublicationDate().isEqual(LocalDateTime.now())){
                    if (checkIfNewsCouldBeSeen(news, homeRegion)){
                        news.setPublishedForKira(true);
                        newsDao.save(news);
                        return Stream.of(news).map(NewsInfo::new);
                    }
                }
            }
        }
    }

    /**
     * Get news by Agent.
     * @param userLogin ID of the user.
     * @return Stream of news info.
     */
    @GetMapping("/game/agent/news/get")
    public Stream<NewsInfo> getNewsByAgent(@RequestParam("userLogin") String userLogin){
        int agentId = userDao.getOne(userLogin).getAgent().getId();
        int kiraId = agentDao.findById(agentId).getNews().get(0).getAgent().getId();
        while (true){
            List<News> newsList = newsDao.findNotPublishedNewsForAgentByKiraIdAndAgentId(kiraId, agentId);
            for (News news: newsList){
                if (news.getPublicationDate().isBefore(LocalDateTime.now()) || news.getPublicationDate().isEqual(LocalDateTime.now())){
                    news.setPublishedForAgent(true);
                    newsDao.save(news);
                    if (!newsDao.isThereNewNews(agentId, kiraId)){
                        boolean isPersonsWereNotUsed = NewsGenerator.generateRandomNews(kiraId, agentId, newsDao, kiraDao, agentDao, personDao, regionDao, false);
                        if (!isPersonsWereNotUsed)
                            return null;
                    }
                    try {
                        return Stream.of(news).map(NewsInfo::new);
                    } catch (Exception e){}

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
