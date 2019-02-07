package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Request;

public class RequestInfo {
    public int id;
    public int pageNum;
    private boolean success;
    public String city;
    public String country;
    public String continent;
    public String personName;
    public String personSername;
    public String personPatr;
    public boolean personSex;

    private RequestInfo(){}

    public RequestInfo(Request request){
        id = request.getId();
        success = request.isSuccess();
        pageNum = request.getPageNumber();
        city = request.getCrimeRegion().getCity();
        country = request.getCrimeRegion().getCountry();
        continent = request.getCrimeRegion().getContinent();
        personName = request.getCrimePerson().getName();
        personSername = request.getCrimePerson().getSurname();
        personPatr = request.getCrimePerson().getPatronymic();
        personSex = request.getCrimePerson().getSex();
    }
}
