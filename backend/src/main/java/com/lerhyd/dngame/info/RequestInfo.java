package com.lerhyd.dngame.info;

import com.lerhyd.dngame.model.Request;

public class RequestInfo {
    public int id;
    public int pageNum;
    public boolean success;
    public String personName;
    public String personSurname;
    public String personPatr;
    public boolean personSex;

    private RequestInfo(){}

    public RequestInfo(Request request){
        id = request.getId();
        success = request.isSuccess();
        pageNum = request.getPageNumber();
        personName = request.getCrimePerson().getName();
        personSurname = request.getCrimePerson().getSurname();
        personPatr = request.getCrimePerson().getPatronymic();
        personSex = request.getCrimePerson().getSex();
    }
}
