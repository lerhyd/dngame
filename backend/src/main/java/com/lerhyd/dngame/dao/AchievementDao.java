package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AchievementDao extends JpaRepository<Achievement, String> {

    List<Achievement> findAchievementsByKiras(int id);

    List<Achievement> findAchievementsByAgents(int id);

    Optional<Achievement> findById(String id);
}