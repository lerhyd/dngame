package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Region;

public class RegionInfo {

    public int id;
    public String country;
    public String city;

    private RegionInfo(){}

    public RegionInfo(Region reg){
        id = reg.getId();
        country = reg.getCountry();
        city = reg.getCity();
    }
}
