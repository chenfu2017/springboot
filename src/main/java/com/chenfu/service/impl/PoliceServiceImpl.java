package com.chenfu.service.impl;

import com.chenfu.mapper.PoliceMapper;
import com.chenfu.pojo.Police;
import com.chenfu.service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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
}
