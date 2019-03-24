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

    public static boolean generateRandomNews(int kiraId, int agentId,
                                             NewsDao newsDao,
                                             KiraDao kiraDao,
                                             AgentDao agentDao,
                                             PersonDao personDao,
                                             RegionDao regionDao,
                                             boolean isFirstGeneration){
        if (newsDao.cntVictimsThatUsedInNews(agentId, kiraId) == personDao.cntAllPersonsWithoutFake())
            return false;
        News templateNews = newsDao.findAllTempleteNewsInRandomOrder().get(0);
        news = new News(
                templateNews.isFromEntry(),
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
        boolean guiltyPersonExists = false;
        if (news.isGuiltyPersonExists())
            if (news.isFake())
                outer: while (!guiltyPersonExists){
                    Person guiltyPerson = personDao.findAllNotCriminalPeronsInRandomOrder().get(0);
                    if (kiraDao.getOne(kiraId).getUser().getProfile().equals(guiltyPerson) || agentDao.getOne(agentId).getUser().getProfile().equals(guiltyPerson))
                        continue outer;
                    if (!newsDao.checkIfNewsGuiltyPersonExists(agentId, kiraId, guiltyPerson.getId())){
                        news.setGuiltyPerson(guiltyPerson);
                        guiltyPersonExists = true;
                    }
                }
            else
                while (!guiltyPersonExists){
                    Person guiltyPerson = personDao.findAllCriminalPeronsInRandomOrder().get(0);
                    if (!newsDao.checkIfNewsGuiltyPersonExists(agentId, kiraId, guiltyPerson.getId())){
                        news.setGuiltyPerson(guiltyPerson);
                        guiltyPersonExists = true;
                    }
                }
        else
            news.setGuiltyPerson(null);

        boolean victimExists = false;

        while (!victimExists){
            Person victim = personDao.findAllPeronsInRandomOrder().get(0);
            if (!newsDao.checkIfNewsVictimExists(agentId, kiraId, victim.getId()) && !newsDao.checkIfVictimDiedInNews(agentId, kiraId, victim.getId()).orElse(false)) {
                news.setVictim(victim);
                victimExists = true;
            }
        }

        news.setPublishedForKira(false);
        news.setPublishedForAgent(false);
        int timeToReadInSeconds = maxTimeInSeconds - kiraDao.getOne(kiraId).getLvl()*(maxTimeInSeconds/maxLevel);
        if (isFirstGeneration)
            news.setPublicationDate(LocalDateTime.now().plusSeconds(5));
        else
            news.setPublicationDate(LocalDateTime.now().plusSeconds(1).plusSeconds(timeToReadInSeconds));
        news.setDistributionRegion(regionDao.findById(worldRegionId));
        news.setCommonRegion(regionDao.findAllRegionsInRandomOrder().get(0));
        newsDao.save(news);
        return true;
    }

}
