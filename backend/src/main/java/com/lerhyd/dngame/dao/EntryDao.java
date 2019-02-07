package com.lerhyd.dngame.dao;

import com.lerhyd.dngame.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface EntryDao extends JpaRepository<Entry, Integer> {

    @Query("select e from Entry e WHERE e.kira.id = :kiraId")
    Collection<Entry> findAllByKira(@Param("kiraId") int kiraId);

    @Transactional
    @Modifying
    @Query("delete from Entry e where e.kira.id = :kiraId")
    void deleteAllByKiraId(@Param("kiraId") int kiraId);

    Entry findById(int id);

    @Query("select count(e) from Entry e where e.kira.id =:kiraId and e.pageNumber=:pageNum")
    int findCntOfEntriesInOnePage(@Param("kiraId") int kiraId, @Param("pageNum") int pageNum);

    boolean existsEntryByVictim_NameAndVictim_SurnameAndVictim_PatronymicAndVictim_Sex(String name,
                                                                                       String surname,
                                                                                       String patr,
                                                                                       boolean sex);

    @Query("select max(e.pageNumber) from Entry e where e.kira.id = :kiraId")
    Optional<Integer> findMaxNumPageByKiraId(@Param("kiraId") int kiraId);

}