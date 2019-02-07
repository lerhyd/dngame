package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RankDao extends JpaRepository<Rank, Integer> {

    @Query("select r.rank from Rank r left join r.agents a left join a.user u where u.id = :userId")
    String findRankByUserIdIfIsAgents(@Param("userId") int userId);

    @Query("select r.rank from Rank r left join r.kiras k left join k.user u where u.id = :userId")
    String findRankByUserIdIfIsKiras(@Param("userId") int userId);

    Rank findById(int id);

    @Query("select r from Rank r where r.points = :points and r.kira=:isKira")
    Rank findByPoints(@Param("points") int points,@Param("isKira") boolean isKira);

}