package com.chenfu.service;


import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Police;
import com.chenfu.pojo.Policemsg;

import java.util.List;
import java.util.Set;

public interface PoliceService {

     List<Police> getPolices();

     JSONResult login(String policeid, String password);

     Set<String> getOnlinePolices();
}
