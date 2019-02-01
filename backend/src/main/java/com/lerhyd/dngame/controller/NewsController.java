package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.NewsInfo;
import com.lerhyd.dngame.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private ActionPlaceDao actionPlaceDao;

    @Autowired
    private RegionDao regionDao;

    @Autowired
    private PersonDao personDao;

    /**
     * Add usual news
     * @param desc description of news
     * @param pubDate the date to publush news
     * @param actionId id of {@link com.lerhyd.dngame.model.Action}
     * @param actionPlaceId id of {@link com.lerhyd.dngame.model.ActionPlace}
     * @param commonRegionId id of {@link com.lerhyd.dngame.model.Region}
     * @param distRegionId id of destination {@link com.lerhyd.dngame.model.Region}
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent}
     * @param kiraId id of {@link KiraDao}
     * @param victimId if of {@link com.lerhyd.dngame.model.Person}
     * @param fakeVictimId id of fake {@link com.lerhyd.dngame.model.Person}
     * @param killerId id of killer {@link com.lerhyd.dngame.model.Person}
     */
    @PostMapping("/news/add")
    public void addNews(@RequestParam("desc") String desc,
                        @RequestParam("pubDate") String pubDate,
                        @RequestParam("actionId") long actionId,
                        @RequestParam("actionPlaceId") long actionPlaceId,
                        @RequestParam("commonRegionId") long commonRegionId,
                        @RequestParam("distRegId") long distRegionId,
                        @RequestParam("agentId") long agentId,
                        @RequestParam("kiraId") long kiraId,
                        @RequestParam("victimId") long victimId,
                        @RequestParam("fakeVictimId") long fakeVictimId,
                        @RequestParam("killerId") long killerId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        News news = new News(desc,
                LocalDateTime.parse(pubDate, formatter),
                    actionDao.findById(actionId),
                    actionPlaceDao.findById(actionPlaceId),
                    personDao.findById(victimId),
                    agentDao.findById(agentId),
                    kiraDao.findById(kiraId),
                    regionDao.findById(distRegionId),
                    regionDao.findById(commonRegionId),
                    personDao.findById(fakeVictimId),
                    personDao.findById(killerId)
                );

        newsDao.save(news);
    }

    /**
     * Get the last news
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent} who is the part of current session
     * @param kiraId id of {@link com.lerhyd.dngame.model.Kira} who is the part of current session
     * @return Stream of news info
     */
    @GetMapping("/news/last")
    public Stream<NewsInfo> getLastNews(@RequestParam("kiraId") long kiraId, @RequestParam("agentId") long agentId){
        Stream<NewsInfo> infoStream = null;
        return Stream.of(newsDao.findTopByOrderByIdDesc()).map(NewsInfo::new);
    }

    /**
     * delete all the news in the world
     * @param kiraId id of {@link com.lerhyd.dngame.model.Kira}
     * @param agentId id of {@link com.lerhyd.dngame.model.Agent}
     */
    @DeleteMapping("/news/delete")
    public void deleteNews(@RequestParam("kiraId") long kiraId, @RequestParam("agentId") long agentId){
        newsDao.deleteAllByKiraIdAndAgentId(kiraId, agentId);
    }

}
