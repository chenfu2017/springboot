package com.chenfu.controller;

import com.chenfu.pojo.Drivermsg;
import com.chenfu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/driver")
public class driverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/showOnline")
    public Set<String> getonline(){
        return driverService.getOnlineDrivers();
    }
}
