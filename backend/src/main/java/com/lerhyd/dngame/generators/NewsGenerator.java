package com.lerhyd.dngame.generators;

import com.lerhyd.dngame.dao.AgentDao;
import com.lerhyd.dngame.dao.KiraDao;
import com.lerhyd.dngame.dao.NewsDao;
import com.lerhyd.dngame.dao.PersonDao;
import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.model.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class NewsGenerator {

    private static News news = null;
    private static Random random = new Random();
    private static int maxTimeInSeconds = 50;
    private static int maxLevel = 10;

    public static boolean generateRandomNews(long kiraId, long agentId,
                                             NewsDao newsDao,
                                             KiraDao kiraDao,
                                             AgentDao agentDao,
                                             PersonDao personDao){
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

}
