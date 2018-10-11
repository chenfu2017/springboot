package com.chenfu.service.impl;

import com.chenfu.mapper.PoliceMapper;
import com.chenfu.netty.PoliceChannelRel;
import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Police;
import com.chenfu.pojo.Policemsg;
import com.chenfu.service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Set;

@Service
public class PoliceServiceImpl implements PoliceService {


    @Autowired
    private PoliceMapper policeMapper;
    @Override
    public List<Police> getPolices() {

        Example example = new Example(Police.class);
        Example.Criteria criteria = example.createCriteria();
        List<Police> polices = policeMapper.selectByExample(example);
        return polices;
    }

    @Override
    public JSONResult login(String policeid,String password) {
        Example example = new Example(Police.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("policeid",policeid);
        criteria.andEqualTo("password", password);
        Police police = policeMapper.selectOneByExample(example);
        if (police!=null){
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("Incorrect username or password!");
    }

    @Override
    public Set<String> getOnlinePolices() {
        return PoliceChannelRel.getOnline();
    }
}
