package com.chenfu.service.impl;

import com.chenfu.mapper.DrivermsgMapper;
import com.chenfu.netty.DriverChannelRel;
import com.chenfu.pojo.Drivermsg;
import com.chenfu.service.DrivermsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
public class DrivermsgServiceImpl implements DrivermsgService {

    @Autowired
    private DrivermsgMapper drivermsgMapper;
    @Override
    public List<Drivermsg> getOnlineDrivermsg() {
        Set<String> driverids = DriverChannelRel.getOnlineDrivers();
        ArrayList<Drivermsg> list = new ArrayList<>();
        for (String driverid : driverids) {
            Drivermsg drivermsg = drivermsgMapper.getDrivermsgById(driverid);
            list.add(drivermsg);
        }
        return list;
    }
}
