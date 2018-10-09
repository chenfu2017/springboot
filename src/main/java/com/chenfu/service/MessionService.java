package com.chenfu.service;


import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Mession;

public interface MessionService {

    JSONResult addMession(String policeid,String driverid);

     boolean isIllegitimate(String driverid);
}
