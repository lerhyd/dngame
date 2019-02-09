package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Agent;
import com.lerhyd.dngame.model.Kira;
import com.lerhyd.dngame.model.User;

public class RatingInfo {

    public String login;
    public int score;
    public int winsByKira;
    public int losesByKira;
    public int winsByAgent;
    public int loseByAgent;

    private RatingInfo(){}

    public RatingInfo(User user){
        login = user.getLogin();
        Kira kira = user.getKira();
        Agent agent = user.getAgent();
        if (kira == null){
            winsByKira = 0;
            losesByKira = 0;
        } else {
            winsByKira = kira.getNumberOfWins();
            losesByKira = kira.getNumberOfLoses();
        }

        if (agent == null){
            winsByAgent = 0;
            loseByAgent = 0;
        } else {
            winsByAgent = agent.getNumberOfWins();
            loseByAgent = agent.getNumberOfLoses();
        }
        score = (winsByAgent+winsByKira)-(loseByAgent+losesByKira);
    }

}
