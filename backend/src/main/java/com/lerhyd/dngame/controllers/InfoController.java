package com.lerhyd.dngame.controllers;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.*;
import com.lerhyd.dngame.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
@RestController
public class InfoController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private KiraDao kiraDao;

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private ActionPlaceDao actionPlaceDao;

    @Autowired
    private RegionDao regionDao;

    @Autowired
    private RuleDao ruleDao;

    /**
     * Get the user's info.
     * @param userLogin ID of the user.
     * @return Stream of user info.
     */
    @GetMapping("/game/user")
    public Stream<UserInfo> getUser(@RequestParam("login") String userLogin){
        User user = userDao.findById(userLogin).get();
        return Stream.of(user).map(UserInfo::new);
    }

    /**
     * Get the user's profile info.
     * @param userLogin ID of the user.
     * @return Stream of person info.
     */
    @GetMapping("/game/user/profile")
    public Stream<PersonInfo> getUserProfile(@RequestParam("login") String userLogin){
        User user = userDao.findById(userLogin).get();
        return Stream.of(user.getProfile()).map(PersonInfo::new);
    }

    /**
     * Get all the region info with continents.
     * @return List of continents.
     */
    @GetMapping("/game/regions/continents")
    public List<String> getAllRegionsWithContinents(){
        return regionDao.findAllRegionsWithContinents();
    }

    /**
     * Get all the region info with countries.
     * @param continent Continent.
     * @return List of countries.
     */
    @GetMapping("/game/regions/countries")
    public List<String> getAllRegionsWithCountries(@RequestParam("continent") String continent){
        return regionDao.findAllRegionsWithCountriesByContinent(continent);
    }

    /**
     * Get all the region info with cities.
     * @return List of cities.
     */
    @GetMapping("/game/regions/cities")
    public List<String> getAllRegionsWithCities(@RequestParam("country") String country){
        return regionDao.findAllRegionsWithCitiesByCountry(country);
    }

    /**
     * Get region id with the city.
     * @param city City.
     * @return Region ID.
     */
    @GetMapping("/game/regions/id")
    public int getRegionIdByCity(@RequestParam("city") String city){
        return regionDao.findRegionIdByCity(city);
    }


    /**
     * Get all alive persons.
     * @param agentId ID of the Agent.
     * @return Stream of person info.
     */
    @GetMapping("/game/persons")
    public Stream<PersonInfo> getPersons(@RequestParam("id") int agentId){
        List<Person> people = personDao.findAllAlivePersonsByAgentId(agentId);
        return people.stream().map(PersonInfo::new);
    }

    /**
     * Get the Kira's info.
     * @param kiraId ID of the Kira.
     * @return Stream of Kira info.
     */
    @GetMapping("/game/kira/status")
    public Stream<KiraInfo> getKira(@RequestParam("id") int kiraId){
        return Stream.of(kiraDao.getOne(kiraId)).map(KiraInfo::new);
    }

    /**
     * Get the Agent's info.
     * @param agentId ID of the Agent.
     * @return Stream of Agent info.
     */
    @GetMapping("/game/agent/status")
    public Stream<AgentInfo> getAgent(@RequestParam("id") int agentId){
        return Stream.of(agentDao.getOne(agentId)).map(AgentInfo::new);
    }

    /**
     * Get all available actions of the Kira.
     * @param kiraId ID of the Kira.
     * @return Stream of action info.
     */
    @GetMapping("/game/kira/action")
    public Stream<ActionInfo> getKiraActions(@RequestParam("id") int kiraId){
        Kira kira = kiraDao.getOne(kiraId);
        return actionDao.findByLvl(kira.getLvl()).stream().map(ActionInfo::new);
    }

    /**
     * Get all available actions of the Agent,
     * @param agentId ID of the Agent.
     * @return Stream of action info.
     */
    @GetMapping("/game/agent/action")
    public Stream<ActionInfo> getAgentActions(@RequestParam("id") int agentId){
        Agent agent = agentDao.getOne(agentId);
        return actionDao.findByLvl(agent.getLvl()).stream().map(ActionInfo::new);
    }

    /**
     * Get all available action places of the Kira.
     * @param kiraId ID of the Kira.
     * @return Stream of action place.
     */
    @GetMapping("/game/kira/actionPlaces")
    public Stream<ActionPlaceInfo> getKiraActionPlace(@RequestParam("id") int kiraId){
        Kira kira = kiraDao.getOne(kiraId);
        return actionPlaceDao.findByLvl(kira.getLvl()).stream().map(ActionPlaceInfo::new);
    }

    /**
     * Get all available action places of the Agent.
     * @param agentId ID of the Agent.
     * @return Stream of action place.
     */
    @GetMapping("/game/agent/actionPlaces")
    public Stream<ActionPlaceInfo> getAgentActionPlace(@RequestParam("id") int agentId){
        Agent agent = agentDao.getOne(agentId);
        return actionPlaceDao.findByLvl(agent.getLvl()).stream().map(ActionPlaceInfo::new);
    }

    /**
     * Get all earned achievements of the Kira.
     * @param kiraId ID of the Kira.
     * @return Stream of achievement info.
     */
    @GetMapping("/game/kira/achievements")
    public Stream<AchievementInfo> getAchievementsOfKira(@RequestParam("id") int kiraId){
        return kiraDao.getOne(kiraId).getAchievements().stream().map(AchievementInfo::new);
    }

    /**
     * Get all earned achievements of the Agent.
     * @param agentId ID of the Agent.
     * @return Stream of achievement info.
     */
    @GetMapping("/game/agent/achievements")
    public Stream<AchievementInfo> getAchievementsOfAgent(@RequestParam("id") int agentId){
        return agentDao.getOne(agentId).getAchievements().stream().map(AchievementInfo::new);
    }

    /**
     * Get the overall ranking of the users.
     * @return Stream of rating info.
     */
    @GetMapping("/game/rating")
    public Stream<RatingInfo> getRating(){
        List<User> users = userDao.findAll();
        return userDao.findAll().stream().sorted(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                int winsOfKiraByU1, losesOfKiraByU1, winsOfAgentByU1, losesOfAgentByU1;
                int winsOfKiraByU2, losesOfKiraByU2, winsOfAgentByU2, losesOfAgentByU2;

                if (u1.getKira() == null){
                    winsOfKiraByU1 = 0;
                    losesOfKiraByU1 = 0;
                } else {
                    winsOfKiraByU1 = u1.getKira().getNumberOfWins();
                    losesOfKiraByU1 = u1.getKira().getNumberOfLoses();
                }

                if (u1.getAgent() == null){
                    winsOfAgentByU1 = 0;
                    losesOfAgentByU1 = 0;
                } else {
                    winsOfAgentByU1 = u1.getAgent().getNumberOfWins();
                    losesOfAgentByU1 = u1.getAgent().getNumberOfLoses();
                }

                if (u2.getKira() == null){
                    winsOfKiraByU2 = 0;
                    losesOfKiraByU2 = 0;
                } else {
                    winsOfKiraByU2 = u2.getKira().getNumberOfWins();
                    losesOfKiraByU2 = u2. getKira().getNumberOfLoses();
                }

                if (u2.getAgent() == null){
                    winsOfAgentByU2 = 0;
                    losesOfAgentByU2 = 0;
                } else {
                    winsOfAgentByU2 = u2.getAgent().getNumberOfWins();
                    losesOfAgentByU2 = u2.getAgent().getNumberOfLoses();
                }

                int scoreOfU1 = (winsOfKiraByU1 + winsOfAgentByU1) - (losesOfKiraByU1 + losesOfAgentByU1);

                int scoreOfU2 = (winsOfKiraByU2 + winsOfAgentByU2) -(losesOfKiraByU2 + losesOfAgentByU2);

                if (scoreOfU1 < scoreOfU2)
                    return -1;
                if (scoreOfU1 > scoreOfU2)
                    return 1;
                if (scoreOfU1 == scoreOfU2)
                    return 0;
                return 0;
            }
        }).map(RatingInfo::new);
    }

    /**
     * Get the new achievement of the Kira.
     * @param kiraId ID of the Kira.
     * @return Stream of achievement info.
     */
    @GetMapping("/game/kira/achievements/new")
    public Stream<AchievementInfo> getNewAchievementOfKira(@RequestParam("id") int kiraId){
        int size = kiraDao.getAchievements(kiraId).size();
        while (true){
            int newSize = kiraDao.getAchievements(kiraId).size();
            if (size < newSize){
                List<Achievement> achievements = kiraDao.getAchievements(kiraId);
                return Stream.of(achievements.get(achievements.size()-1)).map(AchievementInfo::new);
            }
        }
    }

    /**
     * Get the new achievement of the Agent.
     * @param agentId ID of the Agent.
     * @return Stream of achievement info.
     */
    @GetMapping("/game/agent/achievements/new")
    public Stream<AchievementInfo> getNewAchievementOfAgent(@RequestParam("id") int agentId){
        int size = agentDao.getAchievements(agentId).size();
        while (true){
            int newSize = agentDao.getAchievements(agentId).size();
            if (size < newSize){
                List<Achievement> achievements = kiraDao.getAchievements(agentId);
                return Stream.of(achievements.get(achievements.size()-1)).map(AchievementInfo::new);
            }
        }
    }

    /**
     * Get all the rules.
     * @return Stream of rules.
     */
    @GetMapping("/game/rules")
    public Stream<RulesInfo> getRules(){
        return ruleDao.findAll().stream().map(RulesInfo::new);
    }

}
