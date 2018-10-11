package com.chenfu.mapper;

import com.chenfu.pojo.Drivermsg;
import com.chenfu.utils.MyMapper;

public interface DrivermsgMapper extends MyMapper<Drivermsg> {

    Drivermsg getDrivermsgById(String driverid);
}