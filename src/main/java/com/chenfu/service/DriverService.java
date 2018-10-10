package com.chenfu.service;

import com.chenfu.pojo.Drivermsg;

import java.util.Set;

public interface DriverService {
    Set<Drivermsg> getOnlineDrivers();
}
