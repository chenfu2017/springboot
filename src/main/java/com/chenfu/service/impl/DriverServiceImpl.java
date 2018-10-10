package com.chenfu.service.impl;

import com.chenfu.netty.DrivermsgChannelRel;
import com.chenfu.pojo.Drivermsg;
import com.chenfu.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DriverServiceImpl implements DriverService {
    @Override
    public Set<Drivermsg> getOnlineDrivers() {
        return DrivermsgChannelRel.getOnlineDrivers();
    }
}
