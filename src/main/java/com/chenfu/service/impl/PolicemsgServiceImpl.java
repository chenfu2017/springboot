package com.chenfu.service.impl;

import com.chenfu.mapper.PoliceMapper;
import com.chenfu.mapper.PolicemsgMapper;
import com.chenfu.netty.PoliceChannelRel;
import com.chenfu.pojo.Policemsg;
import com.chenfu.service.PolicemsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PolicemsgServiceImpl implements PolicemsgService {

    @Autowired
    private PolicemsgMapper policemsgMapper;
    @Override
    public List<Policemsg> getOnlinePolicemsg() {
        Set<String> onlinePolices = PoliceChannelRel.getOnlinePolices();
        ArrayList<Policemsg> list = new ArrayList<>();
        for (String policeid:onlinePolices
                ) {
            Policemsg policemsg = policemsgMapper.getPolicemsgById(policeid);
            list.add(policemsg);
        }
        return list;
    }
}
