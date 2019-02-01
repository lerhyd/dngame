package com.lerhyd.dngame.validator;

import com.lerhyd.dngame.dao.EntryDao;
import com.lerhyd.dngame.dao.KiraDao;
import com.lerhyd.dngame.request.EntryReq;

public class RequestValidator {

    public static boolean validateEntryReq(EntryReq req, EntryDao entryDao, KiraDao kiraDao) {

        int cntEntriesInPage = entryDao.findCntOfEntriesInOnePage(req.getKiraId(), req.getPageNum());
        if (cntEntriesInPage == 10){
            return false;
        }
        if (!kiraDao.existsById(req.getKiraId())){
            return false;
        }

        req.getActionId();
        req.getActionPlaceId();
        req.getVictimName();
        req.getVictimPatr();
        req.getVictimSername();
        req.isVictimSex();
        req.getDesc();
        req.getDeathDate();
        req.getDeathRegionId();
        return true;
    }
}
