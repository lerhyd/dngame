package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.NewsInfo;
import com.lerhyd.dngame.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
    private RegionDao regionDao;

    @Autowired
    private SupposedVictimDao supposedVictimDao;

    @Autowired
    private PersonDao personDao;

    /**
     * Add news to the world
     * @param publDate publicationDate
     * @param whatDid short description
     * @param actionId id of {@link com.lerhyd.dngame.model.Action}
     * @param whereDidId id of {@link com.lerhyd.dngame.model.Region}
     *                   where action happened
     * @param distRegionId id of {@link com.lerhyd.dngame.model.Region}
     *                   where people can see news
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent}
     *                   who is the part of current session
     * @param kiraId id of {@link com.lerhyd.dngame.model.Kira}
     *                   who is the part of current session
     * @param victimId id of {@link com.lerhyd.dngame.model.Person}
     *                   who is victim
     * @param killerId id of {@link com.lerhyd.dngame.model.Person}
     *                   who is Killer in the news(Not necessarily)
     */
    @PostMapping("/news/add")
    public void addNews(@RequestParam("publDate") LocalDateTime publDate,
                        @RequestParam("whatDid") String whatDid,
                        @RequestParam("action") long actionId,
                        @RequestParam("whereDid") long whereDidId,
                        @RequestParam("distReg") long distRegionId,
                        @RequestParam("agent") long agentId,
                        @RequestParam("kiraId") long kiraId,
                        @RequestParam("overWhom") long victimId,
                        @RequestParam("killer") long killerId){

        News news = new News(whatDid, publDate,
                    actionDao.findById(actionId),
                    agentDao.findById(agentId),
                    kiraDao.findById(kiraId),
                    regionDao.findById(distRegionId),
                    regionDao.findById(whereDidId),
                    supposedVictimDao.findById(victimId),
                    personDao.findById(killerId)
                );

        newsDao.save(news);
    }

    /**
     * Get the last news
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent}
     *                   who is the part of current session
     * @param kiraId id of {@link com.lerhyd.dngame.model.Kira}
     *                   who is the part of current session
     * @return Stream of news info
     */
    @GetMapping("/news/last")
    public Stream<NewsInfo> getLastNews(@RequestParam("kiraId") long kiraId, @RequestParam("agentId") long agentId){
        Stream<NewsInfo> infoStream = null;
        return Stream.of(newsDao.findTopByOrderByIdDesc()).map(NewsInfo::new);
    }

}
