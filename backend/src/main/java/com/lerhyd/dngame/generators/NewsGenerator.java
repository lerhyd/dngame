package com.lerhyd.dngame.generators;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.model.News;

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
        news = newsDao.findRandomNewsTemplate(getRandomNewsId(newsDao));
        news.setKira(kiraDao.getOne(kiraId));
        news.setAgent(agentDao.getOne(agentId));
        if (news.isVictimExists())
            news.setVictim(personDao.getOne(getRandomVictimId(personDao)));
        else
            news.setVictim(null);
        news.setGuiltyPerson(personDao.getOne(getRandomGuiltyPersonId(personDao, news.isFake())));
        int timeToReadInSeconds = maxTimeInSeconds - kiraDao.getOne(kiraId).getLvl()*(maxTimeInSeconds/maxLevel);
        news.setPublicationDate(LocalDateTime.now().plusSeconds(1).plusSeconds(timeToReadInSeconds));

        news.setDistributionRegion(regionDao.getOne(worldRegionId));
        news.setCommonRegion(regionDao.getOne(getRandomCommonRegionId(regionDao)));
        if (news.isDie() == true)
            news.getVictim().setDeathDate(LocalDateTime.now());
        newsDao.save(news);
        return true;
    }

    private static int getRandomNewsId(NewsDao newsDao){
        int cntNewsTemplate = newsDao.cntNewsTemplate();
        if (cntNewsTemplate == 0)
            return 0;
        int cntMinimum = 1;
        int n = cntNewsTemplate - cntMinimum + 1;
        int i = random.nextInt() % n;
        return cntMinimum + i;
    }

    private static int getRandomVictimId(PersonDao personDao){
        int cntVictim = (int)personDao.count();
        if (cntVictim == 0)
            return 0;
        int cntMinimum = 1;
        int n = cntVictim - cntMinimum + 1;
        int i = random.nextInt() % n;
        return cntMinimum + i;
    }

    private static int getRandomGuiltyPersonId(PersonDao personDao, boolean isFake){
        if (isFake){
            int cntNonGuiltyPersons = personDao.cntNonCriminalPersons();
            if (cntNonGuiltyPersons == 0)
                return 0;
            int cntMinimum = 1;
            int n = cntNonGuiltyPersons - cntMinimum + 1;
            int i = random.nextInt() % n;
            return cntMinimum + i;
        } else {
            int cntGuiltyPersons = personDao.cntCriminalPersons();
            if (cntGuiltyPersons == 0)
                return 0;
            int cntMinimum = 1;
            int n = cntGuiltyPersons - cntMinimum + 1;
            int i = random.nextInt() % n;
            return cntMinimum + i;
        }
    }

    private static int getRandomCommonRegionId(RegionDao regionDao){
        int cntRegions = (int)regionDao.count();
        if (cntRegions == 0)
            return 0;
        int cntMinimum = 1;
        int n = cntRegions - cntMinimum + 1;
        int i = random.nextInt() % n;
        return cntMinimum + i;
    }

}
