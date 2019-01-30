package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.EntryInfo;
import com.lerhyd.dngame.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@RestController
public class EntryController {

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private DeathReasonDao deathReasonDao;

    @Autowired
    private DeathPlaceDao deathPlaceDao;

    @Autowired
    private RegionDao regionDao;

    @Autowired
    private NewsDao newsDao;

    @GetMapping("/entry")
    public Stream<EntryInfo> getEntries(@RequestParam("kiraId") long kiraId){
        return entryDao.findAllByKira(kiraId).stream().map(EntryInfo::new);
    }

    @PostMapping("/entry/add")
    public void addEntry(@RequestParam("kiraId") long kiraId,
                         @RequestParam("pageNum") int pageNum,
                         @RequestParam("deathReasonId") int deathReasonId,
                         @RequestParam("victimName") String victimName,
                         @RequestParam("victimSername") String victimSername,
                         @RequestParam("victimPatr") String victimPatr,
                         @RequestParam("victimSex") boolean victimSex,
                         @RequestParam("desc") String desc,
                         @RequestParam("deathDate") String deathDate,
                         @RequestParam("deathPlaceId") long deathPlaceId,
                         @RequestParam("deathRegionId") long deathRegionId)
    {
        boolean isExists = personDao.existsByNameAndSurnameAndPatronymicAndSex(victimName, victimSername, victimPatr, victimSex);
        if (isExists){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            Entry entry = new Entry(
                    pageNum,
                    LocalDateTime.parse(deathDate, formatter),
                    desc,
                    deathReasonDao.findById(deathReasonId),
                    deathPlaceDao.findById(deathPlaceId),
                    regionDao.findById(deathRegionId),
                    kiraDao.findById(kiraId),
                    personDao.findByNameAndSurnameAndPatronymicAndSex(victimName, victimSername, victimPatr, victimSex)
            );
            entryDao.save(entry);
        }
    }

    private News generateNewsFromEntry(Entry entry){
        Kira kira = entry.getKira();
        DeathPlace deathPlace = entry.getDeathPlace();
        LocalDateTime dateTime = entry.getDeathDataTime();
        Region region = entry.getDeathRegion();
        DeathReason deathReason = entry.getDeathReason();
        Person victim = entry.getVictim();

        News news = new News();
        return null;
    }

}
