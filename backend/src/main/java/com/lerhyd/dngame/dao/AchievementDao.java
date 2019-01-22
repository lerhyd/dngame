package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AchievementDao extends JpaRepository<Achievement, String> {

    @Query("select a from Achievement a left join a.kiras kira left join kira.user user where user.id =:userId")
    List<Achievement> findAllByUserIdIfKirasIs(@Param("userId") Long userId);

    @Query("select a from Achievement a left join a.agents agent left join agent.user user where user.id=:userId")
    List<Achievement> findAllByUserIdIfAgentsIs(@Param("userId") Long userId);

    @Query("select a from Achievement a where a.isKiras =:isKiras")
    List<Achievement> findAllByIsKiras(@Param("isKiras") Boolean isKiras);

}