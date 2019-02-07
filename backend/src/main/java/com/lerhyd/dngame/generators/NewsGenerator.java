package com.lerhyd.dngame.generators;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;
import org.apache.commons.lang.SerializationUtils;

import java.time.LocalDateTime;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class NewsGenerator {

    private static News news = null;
    private static int maxTimeInSeconds = 50;
    private static int maxLevel = 10;
    private final static int worldRegionId = 1;

    public static void generateRandomNews(int kiraId, int agentId,
                                             NewsDao newsDao,
                                             KiraDao kiraDao,
                                             AgentDao agentDao,
                                             PersonDao personDao,
                                             RegionDao regionDao){
        News templateNews = newsDao.findAllTempleteNewsInRandomOrder().get(0);
        news = new News(
                templateNews.isPublishedForKira(),
                templateNews.isPublishedForAgent(),
                templateNews.isGuiltyPersonExists(),
                templateNews.isFake(),
                templateNews.isAgentGenerated(),
                templateNews.isDie(),
                templateNews.getDescription(),
                templateNews.getPublicationDate(),
                templateNews.getAction(),
                templateNews.getActionPlace(),
                templateNews.getVictim(),
                templateNews.getAgent(),
                templateNews.getKira(),
                templateNews.getDistributionRegion(),
                templateNews.getCommonRegion(),
                templateNews.getGuiltyPerson()
        );
        news.setKira(kiraDao.getOne(kiraId));
        news.setAgent(agentDao.getOne(agentId));
        if (news.isGuiltyPersonExists())
            if (news.isFake())
                news.setGuiltyPerson(personDao.findAllCriminalPeronsInRandomOrder().get(0));
            else
                news.setGuiltyPerson(personDao.findAllNotCriminalPeronsInRandomOrder().get(0));
        else
            news.setGuiltyPerson(null);
        Person victim = personDao.findAllPeronsInRandomOrder().get(0);
        news.setVictim(victim);
        if (news.isDie()){
            victim.setDeathDate(LocalDateTime.now());
            personDao.save(victim);
        }
        news.setPublishedForKira(false);
        news.setPublishedForAgent(false);
        int timeToReadInSeconds = maxTimeInSeconds - kiraDao.getOne(kiraId).getLvl()*(maxTimeInSeconds/maxLevel);
        news.setPublicationDate(LocalDateTime.now().plusSeconds(1).plusSeconds(timeToReadInSeconds));
        news.setDistributionRegion(regionDao.findById(worldRegionId));
        news.setCommonRegion(regionDao.findAllRegionsInRandomOrder().get(0));
        System.out.println(news.getPublicationDate().toString());
        newsDao.save(news);
    }

}
