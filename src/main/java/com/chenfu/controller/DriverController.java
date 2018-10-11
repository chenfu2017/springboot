package com.chenfu.controller;

import com.chenfu.pojo.Drivermsg;
import com.chenfu.service.DriverService;
import com.chenfu.service.DrivermsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;
    @Autowired
    private DrivermsgService drivermsgService;

    @RequestMapping("/showOnline")
    public Set<String> getonline(){
        return driverService.getOnlineDrivers();
    }

    @RequestMapping("/getMsg")
    public List<Drivermsg> getOnlineDrivers(){
        return drivermsgService.getOnlineDrivermsg();
    }
}
