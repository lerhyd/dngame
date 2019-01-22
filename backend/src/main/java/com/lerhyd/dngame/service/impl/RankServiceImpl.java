package com.lerhyd.dngame.service.impl;

import com.lerhyd.dngame.dao.RankDao;
import com.lerhyd.dngame.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link RankService} interface.
 */

@Service
public class RankServiceImpl implements RankService {

    /**
     * Repository for {@link com.lerhyd.dngame.model.Rank}.
     */
    @Autowired
    private RankDao rankDao;

    /**
     * See rank of the user's class.
     * @param isKira If isKira = true -> get kira's rank, if not -> get agent's rank
     * @param userId user id
     * @return the rank
     */
    @Override
    public String getRank(Boolean isKira, Long userId) {
        if (isKira)
            return rankDao.findRankByUserIdIfIsKiras(userId);
        else
            return rankDao.findRankByUserIdIfIsAgents(userId);
    }
}
