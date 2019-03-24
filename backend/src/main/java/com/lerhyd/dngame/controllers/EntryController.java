package com.lerhyd.dngame.controllers;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.EntryInfo;
import com.lerhyd.dngame.model.*;
import com.lerhyd.dngame.request.EntryReq;
import com.lerhyd.dngame.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
@RestController
public class EntryController {

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private ActionPlaceDao actionPlaceDao;

    @Autowired
    private RegionDao regionDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private RankDao rankDao;

    @Autowired
    private AchievementDao achievementDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserDao userDao;


    /**
     * Get note's pages
     * @param userLogin ID of user.
     * @return Number of pages.
     */
    @GetMapping("/game/note/pages")
    public List<Integer> getNotePages(@RequestParam("userLogin") String userLogin){
        int kiraId = userDao.getOne(userLogin).getKira().getId();
        int maxNum = entryDao.findMaxNumPageByKiraId(kiraId).orElse(1) + 1;
        List<Integer> listOfNums = new ArrayList<>();
        for (int i = 1; i<maxNum; i++){
            listOfNums.add(i);
        }
        System.out.println(listOfNums);
        return listOfNums;
    }

    /**
     * Get all entries of the Kira.
     * @param userLogin ID of user.
     * @return Stream of entry info.
     */
    @GetMapping("/game/entry")
    public Stream<EntryInfo> getEntries(@RequestParam("userLogin") String userLogin, @RequestParam("numPage") int numPage){
        int kiraId = userDao.getOne(userLogin).getKira().getId();
        return entryDao.findAllByKira(kiraId, numPage).stream().map(EntryInfo::new);
    }

    /**
     * Add new death note's entry.
     * @param entryReq Form of entry from request.
     * @return Status:
     * 1 -- There's more then 50 symbols
     * 2 -- Trying to make an entry by skipping an empty page,
     * 3 -- Kira with the ID does not exist,
     * 4 -- Death date is before then current date,
     * 5 -- Current user does not have profile,
     * 6 -- There's no match with the Kira's ID,
     * 7 -- These's no alive victims,
     * 8 -- Kira committed suicide.
     * 9 -- The victim with the ID has already died,
     * 10 -- The entry with the victim already exists,
     * 11 -- The Agent won because the Kira's points less than 0,
     * 12 -- The Kira' location was finally declassified,
     * 0 -- The function was executed correctly,
     * 666 -- The Kira won because he has 300 points or more.
     */
    @PostMapping("/game/entry/add")
    public int addEntry(@RequestBody EntryReq entryReq)
    {
        int numPage;
        int kiraId = userDao.getOne(entryReq.getUserLogin()).getKira().getId();
        int maxNumPage = entryDao.findMaxNumPageByKiraId(kiraId).orElse(0);
        if (maxNumPage == 0)
            numPage = 1;
        else
            numPage = maxNumPage;
        long cntEntriesInPage = entryDao.findCntOfEntriesInOnePage(kiraId, numPage);
        if (cntEntriesInPage == 5){
            numPage++;
        }

        if (entryReq.getDesc().length()>50)
            return 1;

        if (!kiraDao.existsById(kiraId)){
            return 3;
        }

        if (entryReq.getDeathDate() == "")
            return 4;

        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        Instant dateInstant = Instant.from(formatter.parse(entryReq.getDeathDate()));
        LocalDateTime deathDataTime = LocalDateTime.ofInstant(dateInstant, ZoneId.of(ZoneOffset.UTC.getId()));

        if (kiraDao.getOne(kiraId).getUser().getProfile() == null)
            return 5;

        if (kiraDao.getOne(kiraId).getNews().get(0) == null)
            return 6;

        int agentIdToCheck = kiraDao.getOne(kiraId).getNews().get(0).getAgent().getId();
        if (newsDao.cntVictimsThatUsedInNews(kiraId, agentIdToCheck) == personDao.cntAllPersonsWithoutFake())
            return 7;

        deletePointsOfKira(kiraId, 5);

        boolean isEntryVictimExists = entryDao.existsEntryByVictim_NameAndVictim_SurnameAndVictim_PatronymicAndVictim_Sex(
                entryReq.getVictimName(),
                entryReq.getVictimSurname(),
                entryReq.getVictimPatr(),
                entryReq.isVictimSex()
        );
        int victimIdToCheck;
        try {

            victimIdToCheck = personDao.findByNameAndSurnameAndPatronymicAndSex(
                    entryReq.getVictimName(),
                    entryReq.getVictimSurname(),
                    entryReq.getVictimPatr(),
                    entryReq.isVictimSex()
            ).getId();
        } catch (NullPointerException e) {
            victimIdToCheck = 1;
        }
        if (personDao.getOne(victimIdToCheck) == kiraDao.getOne(kiraId).getUser().getProfile())
            return 8; //agent won
        if (isEntryVictimExists)
            return 10;

        Person guiltyPerson = personDao.findByNameAndSurnameAndPatronymicAndSex(
                entryReq.getVictimName(),
                entryReq.getVictimSurname(),
                entryReq.getVictimPatr(),
                entryReq.isVictimSex()
        );

        boolean isPersonExists = personDao.existsByNameAndSurnameAndPatronymicAndSex(entryReq.getVictimName(),
                entryReq.getVictimSurname(),
                entryReq.getVictimPatr(),
                entryReq.isVictimSex());
        if (isPersonExists && !deathDataTime.isBefore(LocalDateTime.now()) &&
                !newsDao.checkIfVictimDiedInNews(agentIdToCheck, kiraId, victimIdToCheck).orElse(false)
                && !newsDao.checkIfVictimDiedInNews(agentIdToCheck, kiraId, victimIdToCheck).orElse(false)) {
            Entry entry = getFormedEntry(entryReq, false, numPage);
            entryDao.save(entry);
            newsDao.save(generateNewsFromEntry(entry));
            boolean isCriminal = personDao.findIfCriminal(
                    entryReq.getVictimName(),
                    entryReq.getVictimSurname(),
                    entryReq.getVictimPatr(),
                    entryReq.isVictimSex()).orElse(false);
            if (!isCriminal) {
                deletePointsOfKira(kiraId, 10);
                System.out.println("delete 10 point from Kira");
            } else {
                addPointsOfKira(kiraId, 15);
                addNumberOfKills(kiraId);
                System.out.println("add 15 points to kira and addNumberOfKills");
            }

        } else {
            Entry entry = getFormedEntry(entryReq, true, numPage);
            entryDao.save(entry);
            deletePointsOfKira(kiraId, 5);
            System.out.println("delete 5 points from Kira");
        }

        int points = kiraDao.findPointsById(kiraId);
        if (points >= 300)
            return 666;//kira won

        if (points < 0)
            return 11;//agent won
        try {
            if (newsDao.findIfKiraWasFound(guiltyPerson.getId(), kiraId)) {
                System.out.println("Kira was found");
                return 12;//agent won
            }
        } catch (Exception e) {}


        boolean isAgentGenerated = false;
        try {
            if (newsDao.findIfNewsIsAgentGenerated(guiltyPerson.getId(), kiraId)){
                int agentId = kiraDao.getOne(kiraId).getNews().get(0).getAgent().getId();
                System.out.println("Kira was caught");
                Agent agentToSave = agentDao.getOne(agentId);
                agentToSave.setPoints(agentToSave.getPoints()+50);
                agentDao.save(agentToSave);
                setRankToAgent(agentId);
                //Capital ach
                Achievement capitalAch = achievementDao.getOne("Capital");
                if (!agentDao.getOne(agentId).getAchievements().contains(capitalAch))
                    if (agentDao.getOne(agentId).getPoints() >= 200){
                        if (agentToSave.getAchievements() == null){
                            List<Achievement> achievements = new ArrayList<>();
                            agentToSave.setAchievements(achievements);
                        }
                        agentToSave.getAchievements().add(capitalAch);
                        agentDao.save(agentToSave);
                        emailService.sendMail("DN game.", agentDao.getOne(agentId).getUser(), "Вы получили достижение Capital.");
                    }
                isAgentGenerated = true;
            }
        } catch (Exception e){}
        Kira kira = kiraDao.getOne(kiraId);
        if (kira.getNumberOfKills() >= 3){
            if (kira.getNumberOfKills() > 30)
                kira.setLvl(11);
            kira.setLvl(kira.getNumberOfKills()/3);
        }
        kiraDao.save(kira);
        setRankToKira(kiraId);
        
        //Welcome ach
        Achievement welcomeAch = achievementDao.getOne("Welcome");
        if (!kiraDao.getOne(kiraId).getAchievements().contains(welcomeAch))
            if (kiraDao.getOne(kiraId).getLvl() == 1){
                Kira kiraToSave = kiraDao.getOne(kiraId);
                if (kiraToSave.getAchievements() == null) {
                    List<Achievement> achievements = new ArrayList<>();
                    kiraToSave.setAchievements(achievements);
                }
                kiraToSave.getAchievements().add(welcomeAch);
                kiraDao.save(kiraToSave);
                emailService.sendMail("DN game.", kiraDao.getOne(kiraId).getUser(), "Вы получили достижение Welcome.");
            }
        //Ad astra ach
        Achievement adAstraAch = achievementDao.getOne("Ad astra");
        if (!kiraDao.getOne(kiraId).getAchievements().contains(adAstraAch))
            if (kiraDao.getOne(kiraId).getLvl() == 5){
                Kira kiraToSave = kiraDao.getOne(kiraId);
                if (kiraToSave.getAchievements() == null) {
                    List<Achievement> achievements = new ArrayList<>();
                    kiraToSave.setAchievements(achievements);
                }
                kiraToSave.getAchievements().add(adAstraAch);
                kiraDao.save(kiraToSave);
                emailService.sendMail("DN game.", kiraDao.getOne(kiraId).getUser(), "Вы получили достижение Ad astra.");
            }
        //Unstoppable ach
        Achievement unstoppableAch = achievementDao.getOne("Unstoppable");
        if (!kiraDao.getOne(kiraId).getAchievements().contains(unstoppableAch))
            if (kiraDao.getOne(kiraId).getLvl() == 10){
                Kira kiraToSave = kiraDao.getOne(kiraId);
                if (kiraToSave.getAchievements() == null) {
                    List<Achievement> achievements = new ArrayList<>();
                    kiraToSave.setAchievements(achievements);
                }
                kiraToSave.getAchievements().add(unstoppableAch);
                kiraDao.save(kiraToSave);
                emailService.sendMail("DN game.", kiraDao.getOne(kiraId).getUser(), "Вы получили достижение Unstoppable.");
            }
        //Capital ach
        Achievement capitalAch = achievementDao.getOne("Capital");
        if (!kiraDao.getOne(kiraId).getAchievements().contains(capitalAch))
            if (kiraDao.getOne(kiraId).getPoints() >= 200){
                Kira kiraToSave = kiraDao.getOne(kiraId);
                if (kiraToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    kiraToSave.setAchievements(achievements);
                }
                kiraToSave.getAchievements().add(capitalAch);
                kiraDao.save(kiraToSave);
                emailService.sendMail("DN game.", kiraDao.getOne(kiraId).getUser(), "Вы получили достижение Capital.");
            }
        //First assassinations ach
        Achievement firstAssassinationsAch = achievementDao.getOne("First assassinations");
        if (!kiraDao.getOne(kiraId).getAchievements().contains(firstAssassinationsAch))
            if (kiraDao.getOne(kiraId).getNumberOfKills() == 10){
                Kira kiraToSave = kiraDao.getOne(kiraId);
                if (kiraToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    kiraToSave.setAchievements(achievements);
                }
                kiraToSave.getAchievements().add(firstAssassinationsAch);
                kiraDao.save(kiraToSave);
                emailService.sendMail("DN game.", kiraDao.getOne(kiraId).getUser(), "Вы получили достижение First assassinations.");
            }
        //Blood path ach
        Achievement bloodPathAch = achievementDao.getOne("Blood path");
        if (!kiraDao.getOne(kiraId).getAchievements().contains(bloodPathAch))
            if (kiraDao.getOne(kiraId).getNumberOfKills() == 20){
                Kira kiraToSave = kiraDao.getOne(kiraId);
                if (kiraToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    kiraToSave.setAchievements(achievements);
                }
                kiraToSave.getAchievements().add(bloodPathAch);
                kiraDao.save(kiraToSave);
                emailService.sendMail("DN game.", kiraDao.getOne(kiraId).getUser(), "Вы получили достижение Blood path.");
            }
        //Uncontrollable killer ach
        Achievement uncontrollableKillerAch = achievementDao.getOne("Uncontrollable killer");
        if (!kiraDao.getOne(kiraId).getAchievements().contains(uncontrollableKillerAch))
            if (kiraDao.getOne(kiraId).getNumberOfWins() == 10){
                Kira kiraToSave = kiraDao.getOne(kiraId);
                if (kiraToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    kiraToSave.setAchievements(achievements);
                }
                kiraToSave.getAchievements().add(uncontrollableKillerAch);
                kiraDao.save(kiraToSave);
                emailService.sendMail("DN game.", kiraDao.getOne(kiraId).getUser(), "Вы получили достижение Uncontrollable killer.");
            }
        //Irrepressible killer ach
        Achievement irrepressibleKillerAch = achievementDao.getOne("Irrepressible killer");
        if (!kiraDao.getOne(kiraId).getAchievements().contains(irrepressibleKillerAch))
            if (kiraDao.getOne(kiraId).getNumberOfWins() == 20){
                Kira kiraToSave = kiraDao.getOne(kiraId);
                if (kiraToSave.getAchievements() == null){
                    List<Achievement> achievements = new ArrayList<>();
                    kiraToSave.setAchievements(achievements);
                }
                kiraToSave.getAchievements().add(irrepressibleKillerAch);
                kiraDao.save(kiraToSave);
                emailService.sendMail("DN game.", kiraDao.getOne(kiraId).getUser(), "Вы получили достижение Irrepressible killer.");
            }
        return 0;
    }

    private void addPointsOfKira(int kiraId, int points){
        Kira kiraToSave = kiraDao.getOne(kiraId);
        kiraToSave.setPoints(kiraToSave.getPoints() + points);
        kiraDao.save(kiraToSave);
    }

    private void deletePointsOfKira(int kiraId, int points){
        Kira kiraToSave = kiraDao.getOne(kiraId);
        kiraToSave.setPoints(kiraToSave.getPoints() - points);
        kiraDao.save(kiraToSave);
    }

    private void addNumberOfKills(int kiraId){
        Kira kiraToSave = kiraDao.getOne(kiraId);
        kiraToSave.setNumberOfKills(kiraToSave.getNumberOfKills() + 1);
        kiraDao.save(kiraToSave);
    }

    private boolean setRankToKira(int kiraId){
        Kira kira = kiraDao.getOne(kiraId);
        boolean isDone = false;

        isDone = setKiraRankInRange(kira, 30, 40, 1);
        if (isDone)
            return true;
        isDone = setKiraRankInRange(kira, 40, 50, 2);
        if (isDone)
            return true;
        isDone = setKiraRankInRange(kira, 50, 60, 3);
        if (isDone)
            return true;
        isDone = setKiraRankInRange(kira, 60, 80, 4);
        if (isDone)
            return true;
        isDone = setKiraRankInRange(kira, 80, 100, 5);
        if (isDone)
            return true;
        isDone = setKiraRankInRange(kira, 100, 170, 6);
        if (isDone)
            return true;
        isDone = setKiraRankInRange(kira, 170, 256, 7);
        if (isDone)
            return true;
        isDone = setKiraRankInRange(kira, 256, 0, 8);
        if (isDone)
            return true;
        return false;

    }

    private boolean setKiraRankInRange(Kira kira, int from, int to, int rankNum){
        if (to != 0){
            if (kira.getPoints() < 30)
                return true;
            if (kira.getPoints() >= from && kira.getPoints() < to){
                if (kira.getRank().getId() > rankDao.findRankByClassAndId(true, rankNum).getId())
                    return true;
                kira.setRank(rankDao.findRankByClassAndId(true, rankNum));
            } else
                return false;
        } else {
            if (kira.getPoints() >= from) {
                if (kira.getRank().getId() > rankDao.findRankByClassAndId(true, rankNum).getId())
                    return true;
                kira.setRank(rankDao.findRankByClassAndId(true, rankNum));
            } else
                return false;
        }

        kiraDao.save(kira);
        return true;
    }

    private News generateNewsFromEntry(Entry entry){
        String desc = entry.getDescription();
        Kira kira = entry.getKira();
        ActionPlace actionPlace = entry.getActionPlace();
        Action action = entry.getAction();
        Region region = regionDao.findAllRegionsInRandomOrder().get(0);
        Person victim = entry.getVictim();
        boolean isDeathDate = false;
        LocalDateTime deathDate = entry.getDeathDataTime();
        LocalDateTime deathWithoutDate = LocalDateTime.now().plusSeconds(40);
        if (deathDate != null)
            isDeathDate = true;

        News news = new News(
                true,
                false,
                false,
                false,
                false,
                false,
                true,
                desc,
                isDeathDate ? deathDate : deathWithoutDate,
                action,
                actionPlace,
                victim,
                kira.getNews().get(0).getAgent(),
                kira,
                region,
                region,
                null
        );

        return news;
    }

    private Entry getFormedEntry(EntryReq entryReq,
                                 boolean isUselessEntry, int numPage){
        int kiraId = userDao.getOne(entryReq.getUserLogin()).getKira().getId();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        Instant dateInstant = Instant.from(formatter.parse(entryReq.getDeathDate()));
        LocalDateTime deathDataTime = LocalDateTime.ofInstant(dateInstant, ZoneId.of(ZoneOffset.UTC.getId()));
        if (!isUselessEntry) {
            personDao.findByNameAndSurnameAndPatronymicAndSex(entryReq.getVictimName(),
                    entryReq.getVictimSurname(),
                    entryReq.getVictimPatr(),
                    entryReq.isVictimSex());
            Entry entry = new Entry(
                    numPage,
                    deathDataTime,
                    entryReq.getDesc(),
                    actionDao.findById(entryReq.getActionId()),
                    actionPlaceDao.findById(entryReq.getActionPlaceId()),
                    kiraDao.findById(kiraId),
                    personDao.findByNameAndSurnameAndPatronymicAndSex(entryReq.getVictimName(),
                                                                      entryReq.getVictimSurname(),
                                                                      entryReq.getVictimPatr(),
                                                                      entryReq.isVictimSex())
            );
            return entry;
        } else {
            Person unrealVictim = new Person(
                    entryReq.getVictimName(),
                    entryReq.getVictimSurname(),
                    entryReq.getVictimPatr(),
                    entryReq.isVictimSex(),
                    LocalDateTime.now(),
                    deathDataTime,
                    true,
                    false,
                    null,
                    null,
                    null
                    );

            Entry entry = new Entry(
                    numPage,
                    deathDataTime,
                    entryReq.getDesc(),
                    actionDao.findById(entryReq.getActionId()),
                    actionPlaceDao.findById(entryReq.getActionPlaceId()),
                    kiraDao.findById(kiraId),
                    unrealVictim
            );
            unrealVictim.setEntry(entry);
            personDao.save(unrealVictim);
            return entry;
        }

    }

    private boolean setRankToAgent(int agentId){
        Agent agent = agentDao.getOne(agentId);
        boolean isDone = false;

        isDone = setAgentRankInRange(agent, 30, 40, 9);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 40, 50, 10);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 50, 60, 11);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 60, 80, 12);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 80, 100, 13);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 100, 170, 14);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 170, 256, 15);
        if (isDone)
            return true;
        isDone = setAgentRankInRange(agent, 256, 0, 16);
        if (isDone)
            return true;
        return false;

    }

    private boolean setAgentRankInRange(Agent agent, int from, int to, int rankNum){
        if (to != 0){
            if (agent.getPoints() <= 30)
                return true;
            if (agent.getPoints() >= from && agent.getPoints() < to){
                if (agent.getRank().getId() > rankDao.findRankByClassAndId(false, rankNum).getId())
                    return true;
                agent.setRank(rankDao.findRankByClassAndId(false, rankNum));
            } else
                return false;
        } else {
            if (agent.getPoints() >= from) {
                if (agent.getRank().getId() > rankDao.findRankByClassAndId(false, rankNum).getId())
                    return true;
                agent.setRank(rankDao.findRankByClassAndId(false, rankNum));
            } else
                return false;
        }

        agentDao.save(agent);
        return true;
    }



}
