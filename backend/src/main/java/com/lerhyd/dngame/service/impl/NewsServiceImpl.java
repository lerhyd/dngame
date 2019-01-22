package com.lerhyd.dngame.service.impl;

import com.lerhyd.dngame.dao.NewsDao;
import com.lerhyd.dngame.model.News;
import com.lerhyd.dngame.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Implementation of {@link NewsService} interface.
 */

@Service
public class NewsServiceImpl implements NewsService {

    /**
     * Repository for {@link News}.
     */
    @Autowired
    private NewsDao newsDao;

    /**
     * Get news(see news) for the current game match.
     * @param kiraId kira id
     * @param agentId agent id
     * @return collection of news
     */
    @Override
    public Collection<News> getNews(Long kiraId, Long agentId) {
        return newsDao.findAllByKiraAndAgent(kiraId, agentId);
    }

    /**
     * Add news.
     * @param news news entity
     */
    @Override
    public void addNews(News news) {
        newsDao.save(news);
    }

    /**
     * Open tablet/Get all news by Agent id.
     * @param agentId agent id
     * @return collection of news
     */
    @Override
    public Collection<News> openTablet(Long agentId) {
        return newsDao.findAllByAgentId(agentId);
    }

    /**
     * Delete news from the last match.
     * @param kiraId kira id
     * @param agentId agent id
     */
    @Override
    public void deleteNewsOfTheLastGame(Long kiraId, Long agentId) {
        newsDao.deleteAllByKiraIdAndAgentId(kiraId, agentId);
    }
}
