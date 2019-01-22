package com.lerhyd.dngame.service.impl;

import com.lerhyd.dngame.dao.KiraDao;
import com.lerhyd.dngame.model.Kira;
import com.lerhyd.dngame.service.KiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link KiraService} interface.
 */

@Service
public class KiraServiceImpl implements KiraService {

    /**
     * Repository for {@link com.lerhyd.dngame.model.Kira}.
     */
    @Autowired
    private KiraDao kiraDao;

    /**
     * Get points of the kira.
     * @param kiraId kira id
     * @return value of points
     */
    @Override
    public Integer getPoints(Long kiraId) {
        return kiraDao.findPointsById(kiraId);
    }

    /**
     * Set region that the Kira lives in.
     * @param kiraId kira id
     * @param country country from the game world
     * @param city city from the game world
     */
    @Override
    public void setRegion(Long kiraId, String country, String city) {
        Long regionId = kiraDao.findRegionsIdByCountryAndCity(country, city);
        kiraDao.setRegion(kiraId, regionId);
    }

    @Override
    public Kira getKira(Long kira) {
        return kiraDao.getOne(kira);
    }
}
