package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Region;

public class RegionInfo {

    public int id;
    public String country;
    public String city;
    public String continent;

    private RegionInfo(){}

    public RegionInfo(Region reg){
        id = reg.getId();
        country = reg.getCountry();
        city = reg.getCity();
        continent = reg.getContinent();
    }
}
