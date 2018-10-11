package com.chenfu.service.impl;

import com.chenfu.mapper.MessionMapper;
import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Mession;
import com.chenfu.service.MessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.Date;
import java.util.List;

@Service
public class MessionServiceImpl implements MessionService {


    @Autowired
    private MessionMapper messionMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public JSONResult addMession(String policeid,String driverid) {
        Example example = new Example(Mession.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("driverid",driverid);
        criteria.andEqualTo("policeid",policeid);
        Mession mession = messionMapper.selectOneByExample(example);
        if(mession==null){
            mession = new Mession();
            mession.setPoliceid(policeid);
            mession.setDriverid(driverid);
            mession.setCreateTime(new Date());
            mession.setFinish(false);
            messionMapper.insert(mession);
            return JSONResult.ok();
        } else {
            if(mession.getFinish()==true){
                mession.setFinish(false);
                mession.setCreateTime(new Date());
                messionMapper.updateByPrimaryKey(mession);
                return JSONResult.ok();
            } else {
                return JSONResult.errorMsg("mession already exist!");
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
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
