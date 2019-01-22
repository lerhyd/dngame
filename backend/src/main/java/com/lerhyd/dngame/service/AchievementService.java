package com.lerhyd.dngame.service;

import com.lerhyd.dngame.model.Achievement;

import java.util.Collection;

public interface AchievementService {

    void addAchievement(Achievement achievement);
    Collection<Achievement> getCurrentAchievements(Long userId, Boolean isKira);
    Collection<Achievement> getAllAchievementsByClass(Boolean isKira);

}
