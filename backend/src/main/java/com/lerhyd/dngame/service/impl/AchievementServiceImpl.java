package com.lerhyd.dngame.service.impl;

import com.lerhyd.dngame.dao.AchievementDao;
import com.lerhyd.dngame.model.Achievement;
import com.lerhyd.dngame.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Implementation of {@link AchievementService} interface
 * for game achievements.
 */
@Service
public class AchievementServiceImpl implements AchievementService {

    /**
     * Repository for {@link Achievement}.
     */
    @Autowired
    private AchievementDao achievementDao;

    /**
     * Add new achievement.
     * @param achievement Achievement object to save
     */
    @Override
    public void addAchievement(Achievement achievement) {
        achievementDao.save(achievement);
    }

    /**
     * Get achievements of Kira/Agent by user id.
     * @param userId Id of user
     * @param isKira If isKira = true -> get kira's achievements, if not -> get agent's achievements
     * @return
     */
    @Override
    public Collection<Achievement> getCurrentAchievements(Long userId, Boolean isKira) {
        if (isKira) {
            return achievementDao.findAllByUserIdIfKirasIs(userId);
        } else {
            return achievementDao.findAllByUserIdIfAgentsIs(userId);
        }
    }

    /**
     * Get all achievements that can get a given class(Kira/Agent).
     * @param isKira If isKira = true -> get kira's achievements, if not -> get agent's achievements
     * @return achievements collection
     */
    @Override
    public Collection<Achievement> getAllAchievementsByClass(Boolean isKira) {
        return achievementDao.findAllByIsKiras(isKira);
    }
}
