package com.chenfu.service.impl;

import com.chenfu.netty.DriverChannelRel;
import com.chenfu.pojo.Drivermsg;
import com.chenfu.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DriverServiceImpl implements DriverService {
    @Override
    public Set<String> getOnlineDrivers() {
        return DriverChannelRel.getOnlineDrivers();
    }
}
