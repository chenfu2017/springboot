package com.chenfu.service;

import com.chenfu.pojo.JSONResult;

public interface MessionService {

    JSONResult addMession(String policeid,String driverid);

    public String getPoliceid(String driverid);
}
