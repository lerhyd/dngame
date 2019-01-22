package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EntryDao extends JpaRepository<Entry, Integer> {

    @Query("select e from Entry e WHERE e.kira.id = :kiraId")
    Collection<Entry> openNote(@Param("kiraId") Long kiraId);

}