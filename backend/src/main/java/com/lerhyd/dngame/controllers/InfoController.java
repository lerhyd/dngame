package com.lerhyd.dngame.controllers;

import com.lerhyd.dngame.dao.*;
import com.lerhyd.dngame.info.*;
import com.lerhyd.dngame.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
     * Get full region id.
     * @param city City.
     * @return Region ID.
     */
    @GetMapping("/game/regions/id/full")
    public int getRegionId(@RequestParam("continent") String continent, @RequestParam("country") String country, @RequestParam("city") String city){
        if (country.equals(String.valueOf(0)))
            return regionDao.findRegionIdwithoutCountry(continent);
        if (city.equals(String.valueOf(0)))
            return regionDao.findRegionIdwithoutCity(country, continent);
        return regionDao.findRegionId(city, country, continent);
    }

    /**
     * Get all alive persons.
     * @param usedPersonId ID of the used person.
     * @return Stream of person info.
     */
    @GetMapping("/game/persons")
    public Stream<PersonInfo> getPersons(@RequestParam("usedPerson") int usedPersonId){
        List<Person> people = new ArrayList<>();
        List<Person> findPeople = personDao.findAllPersons(usedPersonId);
        for (int i = 0; i<5; i++)
            people.add(findPeople.get(i));
        return people.stream().map(PersonInfo::new);
    }

    /**
     * Get the Kira's info.
     * @param userLogin ID of the user.
     * @return Stream of Kira info.
     */
    @GetMapping("/game/kira/status")
    public Stream<KiraInfo> getKira(@RequestParam("userLogin") String userLogin){
        int kiraId = userDao.getOne(userLogin).getKira().getId();
        return Stream.of(kiraDao.getOne(kiraId)).map(KiraInfo::new);
    }

    /**
     * Get the Agent's info.
     * @param userLogin ID of the user.
     * @return Stream of Agent info.
     */
    @GetMapping("/game/agent/status")
    public Stream<AgentInfo> getAgent(@RequestParam("userLogin") String userLogin){
        int agentId = userDao.getOne(userLogin).getAgent().getId();
        return Stream.of(agentDao.getOne(agentId)).map(AgentInfo::new);
    }

    /**
     * Get all available actions of the Kira.
     * @param userLogin ID of the user.
     * @return Stream of action info.
     */
    @GetMapping("/game/kira/action")
    public Stream<ActionInfo> getKiraActions(@RequestParam("userLogin") String userLogin){
        int kiraId = userDao.getOne(userLogin).getKira().getId();
        Kira kira = kiraDao.getOne(kiraId);
        return actionDao.findByLvl(kira.getLvl()).stream().map(ActionInfo::new);
    }

    /**
     * Get all available actions of the Agent,
     * @param userLogin ID of the user.
     * @return Stream of action info.
     */
    @GetMapping("/game/agent/action")
    public Stream<ActionInfo> getAgentActions(@RequestParam("userLogin") String userLogin){
        int agentId = userDao.getOne(userLogin).getAgent().getId();
        Agent agent = agentDao.getOne(agentId);
        return actionDao.findByLvl(agent.getLvl()).stream().map(ActionInfo::new);
    }

    /**
     * Get all available action places of the Kira.
     * @param userLogin ID of the user.
     * @return Stream of action place.
     */
    @GetMapping("/game/kira/actionPlaces")
    public Stream<ActionPlaceInfo> getKiraActionPlace(@RequestParam("userLogin") String userLogin){
        int kiraId = userDao.getOne(userLogin).getKira().getId();
        Kira kira = kiraDao.getOne(kiraId);
        return actionPlaceDao.findByLvl(kira.getLvl()).stream().map(ActionPlaceInfo::new);
    }

    /**
     * Get all available action places of the Agent.
     * @param userLogin ID of the user.
     * @return Stream of action place.
     */
    @GetMapping("/game/agent/actionPlaces")
    public Stream<ActionPlaceInfo> getAgentActionPlace(@RequestParam("userLogin") String userLogin){
        int agentId = userDao.getOne(userLogin).getAgent().getId();
        Agent agent = agentDao.getOne(agentId);
        return actionPlaceDao.findByLvl(agent.getLvl()).stream().map(ActionPlaceInfo::new);
    }

    /**
     * Get all earned achievements of the Kira.
     * @param userLogin ID of the user.
     * @return Stream of achievement info.
     */
    @GetMapping("/game/kira/achievements")
    public Stream<AchievementInfo> getAchievementsOfKira(@RequestParam("userLogin") String userLogin){
        int kiraId = userDao.getOne(userLogin).getKira().getId();
        return kiraDao.getOne(kiraId).getAchievements().stream().map(AchievementInfo::new);
    }

    /**
     * Get all earned achievements of the Agent.
     * @param userLogin ID of the user.
     * @return Stream of achievement info.
     */
    @GetMapping("/game/agent/achievements")
    public Stream<AchievementInfo> getAchievementsOfAgent(@RequestParam("userLogin") String userLogin){
        int agentId = userDao.getOne(userLogin).getAgent().getId();
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
     * @param userLogin ID of the user.
     * @return Stream of achievement info.
     */
    @GetMapping("/game/kira/achievements/new")
    public Stream<AchievementInfo> getNewAchievementOfKira(@RequestParam("userLogin") String userLogin){
        int kiraId = userDao.getOne(userLogin).getKira().getId();
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
     * @param userLogin ID of the user.
     * @return Stream of achievement info.
     */
    @GetMapping("/game/agent/achievements/new")
    public Stream<AchievementInfo> getNewAchievementOfAgent(@RequestParam("userLogin") String userLogin){
        int agentId = userDao.getOne(userLogin).getAgent().getId();
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

    @GetMapping("/game/randomCriminalPeople")
    public Stream<PersonInfo> getRandomCriminalPeople(){
        return personDao.findAllCriminalPeronsInRandomOrder().subList(0,7).stream().map(PersonInfo::new);
    }

}
