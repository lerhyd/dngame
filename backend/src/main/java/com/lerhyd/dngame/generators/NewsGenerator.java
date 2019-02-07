package com.lerhyd.dngame.generators;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;

import java.time.LocalDateTime;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class NewsGenerator {

    private static News news = null;
    private static Random random = new Random();
    private static int maxTimeInSeconds = 50;
    private static int maxLevel = 10;
    private final static int worldRegionId = 1;

    public static boolean generateRandomNews(int kiraId, int agentId,
                                             NewsDao newsDao,
                                             KiraDao kiraDao,
                                             AgentDao agentDao,
                                             PersonDao personDao,
                                             RegionDao regionDao){
        news = newsDao.findAllTempleteNewsInRandomOrder().get(0);
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
        news.setPublished(false);
        int timeToReadInSeconds = maxTimeInSeconds - kiraDao.getOne(kiraId).getLvl()*(maxTimeInSeconds/maxLevel);
        news.setPublicationDate(LocalDateTime.now().plusSeconds(1).plusSeconds(timeToReadInSeconds));
        news.setDistributionRegion(regionDao.findById(worldRegionId));
        news.setCommonRegion(regionDao.findAllRegionsInRandomOrder().get(0));
        newsDao.save(news);
        return true;
    }

}
