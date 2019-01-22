package com.lerhyd.dngame.service;


import com.lerhyd.dngame.model.Entry;

import java.util.Collection;

public interface EntryService {

    Collection<Entry> openNote(Long kiraId);
    Collection<Entry> openListOfVictims(Long kiraId);
    void addEntry(Entry entry);

}
