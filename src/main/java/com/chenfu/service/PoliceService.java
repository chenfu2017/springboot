package com.chenfu.service;


import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Police;

import java.util.List;

public interface PoliceService {

    public List<Police> getPolices();

    public JSONResult login(String policeid, String password);
}
