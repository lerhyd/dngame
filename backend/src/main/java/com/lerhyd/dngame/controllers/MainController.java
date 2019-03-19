package com.lerhyd.dngame.controllers;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.generators.NewsGenerator;
import com.lerhyd.dngame.model.*;
import com.lerhyd.dngame.request.PersonReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SuppressWarnings("Duplicates")
@RestController
public class MainController {

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private RankDao rankDao;

    @Autowired
    private RegionDao regionDao;

    /**
     * Create profile of the user.
     * @param personReq Form of the person.
     * @return Status:
     * 888 -- The userName does not exist,
     * 666 -- The user is not authenticated,
     * 1 -- User with the login does not exist,
     * 2 -- User already has profile,
     * 3 -- There's already person with the identification data,
     * 0 -- The function was executed correctly.
     */
    @PostMapping("/game/profile/create")
    public int createProfile(@RequestBody PersonReq personReq){
        if (personReq.getUserLogin() == null)
            return 888;
        if (!userDao.getOne(personReq.getUserLogin()).isConfirmed())
            return 666;
        if (userDao.getOne(personReq.getUserLogin()) == null)
            return 1;
        User u = userDao.getOne(personReq.getUserLogin());
        Person personToCheck = u.getProfile();
        if (personToCheck != null)
            return 2;
        if (personDao.existsByNameAndSurnameAndPatronymicAndSex(personReq.getName(),
                                                                personReq.getSurname(),
                                                                personReq.getPatr(),
                                                                personReq.isSex()))
            return 3;
        if (personReq.getBornDate() == "")
            return 4;
        Person p = new Person();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        Instant dateInstant = Instant.from(formatter.parse(personReq.getBornDate()));
        p.setName(personReq.getName());
        p.setSurname(personReq.getSurname());
        p.setPatronymic(personReq.getPatr());
        p.setBornDate(LocalDateTime.ofInstant(dateInstant, ZoneId.of(ZoneOffset.UTC.getId())));
        p.setSex(personReq.isSex());
        p.setFake(false);
        p.setCriminal(false);
        u.setProfile(p);
        personDao.save(p);
        userDao.save(u);
        return 0;
    }

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    /**
     * Delete the user's profile.
     * @param userLogin ID of the user.
     * @return Status:
     * 1 -- there's no profile of the user,
     * 0 -- The function was executed correctly.
     */
    @PostMapping("/game/profile/delete")
    public int deleteProfile(@RequestParam("login") String userLogin){
        if (userDao.getOne(userLogin).getProfile() == null)
            return 1;
        User user = userDao.getOne(userLogin);
        user.setProfile(null);
        userDao.save(user);
        personDao.deleteById(user.getProfile().getId());
        return 0;
    }

    @GetMapping("/game/profile")
    public boolean hasProfile(@RequestParam("login") String userLogin){
        if (userDao.getOne(userLogin).getProfile() == null) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Choose class and begin the game.
     * @param isKira Selected class.
     * @param userLogin ID of the user.
     * @param regionId ID of the region of the user in the match.
     * @return Status:
     * 1 -- User with the login does not exist,
     * 2 -- User does not have profile,
     * 3 -- User is already in match,
     * 4 -- All the person's were used in news,
     * 0 -- The function was executed correctly.
     */
    @PostMapping("/game/class/choose")
    public int setMainClass(@RequestParam("isKira") boolean isKira,
                             @RequestParam("userLogin") String userLogin,
                             @RequestParam("regionId") int regionId){
        if (userDao.getOne(userLogin) == null)
            return 1;
        User u = userDao.getOne(userLogin);
        if (u.getProfile() == null)
            return 2;
        if (u.getKira().getNews() != null || u.getAgent().getNews() != null)
            return 3;
        if (isKira){
            Kira k;
            if (u.getKira() != null)
                k = kiraDao.getOne(u.getKira().getId());
            else {
                k = new Kira();
                k.setNumberOfLoses(0);
                k.setNumberOfWins(0);
            }
            k.setNumberOfKills(0);
            k.setPoints(30);
            k.setLvl(0);
            k.setUser(u);
            k.setNews(null);
            k.setRank(rankDao.findByPoints(k.getPoints(), true));
            k.setRegion(regionDao.findById(regionId));
            u.setKira(k);
            kiraDao.save(k);
            userDao.save(u);
            findOpponent(isKira, k.getId());
            int agentId = k.getNews().get(0).getAgent().getId();
            boolean isPersonsWereNotUsed = NewsGenerator.generateRandomNews(k.getId(), agentId, newsDao, kiraDao, agentDao, personDao, regionDao);
            if (!isPersonsWereNotUsed)
                return 4;
        } else {
            Agent a;
            if (u.getAgent() != null)
                a = agentDao.getOne(u.getAgent().getId());
            else{
                a = new Agent();
                a.setNumberOfLoses(0);
                a.setNumberOfWins(0);
            }
            a.setNumberOfCaughtKillers(0);
            a.setPoints(30);
            a.setLvl(0);
            a.setUser(u);
            a.setNews(null);
            a.setRank(rankDao.findByPoints(a.getPoints(), false));
            a.setRegion(regionDao.findById(regionId));
            u.setAgent(a);
            agentDao.save(a);
            userDao.save(u);
            findOpponent(isKira, a.getId());
        }
        return 0;
    }

    public void findOpponent(boolean isKira, int classId){
        boolean isFound = false;

        while (!isFound){
            if (isKira){
                List<Agent> agents = agentDao.findAgentsWithoutNews();
                if (isMatchCreated(isKira, classId))
                    break;

                if (!agents.isEmpty()){
                    Kira kira = kiraDao.findById(classId);
                    Agent agent = agents.get(0);
                    createMatch(kira.getId(), agent.getId());
                    isFound = true;
                }
            } else {
                List<Kira> kiras = kiraDao.findKirasWithoutNews();

                if (isMatchCreated(isKira, classId))
                    break;

                if (!kiras.isEmpty()){
                    Agent agent = agentDao.findById(classId);
                    Kira kira = kiras.get(0);
                    createMatch(kira.getId(), agent.getId());
                    isFound = true;
                }

            }

        }
    }

    public void createMatch(int kiraId, int agentId){
        News news = new News();
        Kira kira = kiraDao.findById(kiraId);
        Agent agent = agentDao.findById(agentId);
        news.setPublishedForKira(true);
        news.setPublishedForAgent(true);
        news.setKira(kira);
        news.setAgent(agent);
        news.setDescription(kira.getUser().getLogin() + " and " + agent.getUser().getLogin() + " has been connected");
        news.setAgentGenerated(false);
        newsDao.save(news);
        List<News> newsList = newsDao.findAllByKiraAndAgent(kiraId, agentId);
        kira.setNews(newsList);
        agent.setNews(newsList);
        kiraDao.save(kira);
        agentDao.save(agent);
    }

    public boolean isMatchCreated(boolean isKira, int classId){
        if (isKira){
            return kiraDao.existsWithNewsByKiraId(classId);
        } else {
            return agentDao.existsWithNewsByAgentId(classId);
        }
    }



}
