package com.chenfu.service.impl;

import com.chenfu.mapper.MessionMapper;
import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Mession;
import com.chenfu.service.MessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.Date;
import java.util.List;

@Service
public class MessionServiceImpl implements MessionService {


    @Autowired
    private MessionMapper messionMapper;

    public JSONResult addMession(String policeid,String driverid) {
        Mession mession = new Mession();
        mession.setDriverid(driverid);
        mession.setPoliceid(policeid);
        boolean exists = messionMapper.existsWithPrimaryKey(mession);
        if(exists){
            return JSONResult.errorMsg("mession already exist!");
        } else {
            mession.setCreateTime(new Date());
            messionMapper.insert(mession);
            return JSONResult.ok();
        }
    }

    @Override
    public String getPoliceid(String driverid) {

        Example example = new Example(Mession.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("driverid",driverid);
        Mession mession = messionMapper.selectOneByExample(example);
        if (mession == null) {
            return null;
        }
        return mession.getPoliceid();
    }

}
