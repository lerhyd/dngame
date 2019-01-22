package com.lerhyd.dngame.service;


import com.lerhyd.dngame.model.News;

import java.util.Collection;

public interface NewsService {

    Collection<News> getNews(Long kiraId, Long agentId);
    void addNews(News news);
    Collection<News> openTablet(Long agentId);
    void deleteNewsOfTheLastGame(Long kiraId, Long agentId);

}
