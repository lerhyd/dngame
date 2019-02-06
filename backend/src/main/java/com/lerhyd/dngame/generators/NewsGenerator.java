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
    private final static long worldRegionId = 1;

    public static boolean generateRandomNews(long kiraId, long agentId,
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
        return true;
    }

    private static long getRandomNewsId(NewsDao newsDao){
        long cntNewsTemplate = newsDao.cntNewsTemplate();
        if (cntNewsTemplate == 0)
            return 0;
        long cntMinimum = 1;
        long n = cntNewsTemplate - cntMinimum + 1;
        long i = random.nextLong() % n;
        return cntMinimum + i;
    }

    private static long getRandomVictimId(PersonDao personDao){
        long cntVictim = personDao.count();
        if (cntVictim == 0)
            return 0;
        long cntMinimum = 1;
        long n = cntVictim - cntMinimum + 1;
        long i = random.nextLong() % n;
        return cntMinimum + i;
    }

    private static long getRandomGuiltyPersonId(PersonDao personDao, boolean isFake){
        if (isFake){
            long cntNonGuiltyPersons = personDao.cntNonCriminalPersons();
            if (cntNonGuiltyPersons == 0)
                return 0;
            long cntMinimum = 1;
            long n = cntNonGuiltyPersons - cntMinimum + 1;
            long i = random.nextLong() % n;
            return cntMinimum + i;
        } else {
            long cntGuiltyPersons = personDao.cntCriminalPersons();
            if (cntGuiltyPersons == 0)
                return 0;
            long cntMinimum = 1;
            long n = cntGuiltyPersons - cntMinimum + 1;
            long i = random.nextLong() % n;
            return cntMinimum + i;
        }
    }

    private static long getRandomCommonRegionId(RegionDao regionDao){
        long cntRegions = regionDao.count();
        if (cntRegions == 0)
            return 0;
        long cntMinimum = 1;
        long n = cntRegions - cntMinimum + 1;
        long i = random.nextLong() % n;
        return cntMinimum + i;
    }

}
