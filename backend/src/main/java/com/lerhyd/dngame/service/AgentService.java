package com.lerhyd.dngame.service;

public interface AgentService {

    Integer getPoints(Long agentId);
    void setRegion(Long agentId, String country, String city);
}
