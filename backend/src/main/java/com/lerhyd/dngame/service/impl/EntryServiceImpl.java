package com.lerhyd.dngame.service.impl;

import com.lerhyd.dngame.dao.EntryDao;
import com.lerhyd.dngame.model.Entry;
import com.lerhyd.dngame.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Implementation of {@link EntryService} interface
 * for work with entries.
 */

@Service
public class EntryServiceImpl implements EntryService {

    /**
     * Repository for {@link Entry}.
     */
    @Autowired
    private EntryDao entryDao;

    /**
     * Open note(get all entries that are written in the note) of the Kira.
     * @param kiraId kira id
     * @return collection of all the entries in the kira's note
     */
    @Override
    public Collection<Entry> openNote(Long kiraId) {
        return entryDao.openNote(kiraId);
    }

    /**
     * Get all entries that are written in the note of the Kira.
     * @param kiraId kira id
     * @return collection of all the entries in the kira's note
     */
    @Override
    public Collection<Entry> openListOfVictims(Long kiraId) {
        return entryDao.openNote(kiraId);
    }

    /**
     * Write new entry in the Kira's note.
     * @param entry entry
     */
    @Override
    public void addEntry(Entry entry) {
        entryDao.save(entry);
    }
}
