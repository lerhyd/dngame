package com.lerhyd.dngame.service.impl;

import com.lerhyd.dngame.dao.AgentDao;
import com.lerhyd.dngame.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link AgentService} interface.
 */
@Service
public class AgentServiceImpl implements AgentService {

    /**
     * Repository for {@link com.lerhyd.dngame.model.Agent}.
     */
    @Autowired
    private AgentDao agentDao;

    /**
     * Get points.
     * @param agentId agent id
     * @return points
     */
    @Override
    public Integer getPoints(Long agentId) {
        return agentDao.findPointsById(agentId);
    }

    /**
     * Set home region to agent.
     * @param agentId agent id
     * @param country country name
     * @param city city name
     */
    @Override
    public void setRegion(Long agentId, String country, String city) {
        Long regionId = agentDao.findRegionsIdByCountryAndCity(country, city);
        agentDao.setRegionByAgentIdAndRegionId(agentId, regionId);
    }
}
