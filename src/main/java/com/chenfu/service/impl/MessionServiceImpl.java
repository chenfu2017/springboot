package com.chenfu.service.impl;

import com.chenfu.mapper.MessionMapper;
import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Mession;
import com.chenfu.service.MessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.Date;

@Service
public class MessionServiceImpl implements MessionService {


    @Autowired
    private MessionMapper messionMapper;

    public JSONResult addMession(String policeid,String driverid) {
        Example example = new Example(Mession.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("policeid", policeid);
        criteria.andEqualTo("driverid",driverid);
        Mession mession = messionMapper.selectOneByExample(example);
        if (mession == null) {
            mession = new Mession();
            mession.setPoliceid(policeid);
            mession.setDriverid(driverid);
            mession.setCreateTime(new Date());
            messionMapper.insert(mession);
            return JSONResult.ok();
        }
        return JSONResult.errorMsg("mession already exist!");
    }
}
