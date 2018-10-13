package com.chenfu.service.impl;


import com.chenfu.mapper.PoliceMapper;
import com.chenfu.netty.PoliceChannelRel;
import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Police;
import com.chenfu.service.PoliceService;
import com.mysql.jdbc.StringUtils;
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
        if(policeid==null ||password==null ||policeid.equals("")||password.equals("")){
            return JSONResult.errorMsg("name or password can not be empty.");
        }
        String cpassword = policeMapper.login(policeid);
        if(StringUtils.isNullOrEmpty(cpassword)) {
            Police police = new Police();
            police.setPoliceid(policeid);
            police.setPassword(password);
            policeMapper.insertSelective(police);
            JSONResult jsonResult = JSONResult.ok();
            jsonResult.setMsg("regist successfully");
            return jsonResult;
        } else {
            if (password.equals(cpassword)){
                JSONResult jsonResult = JSONResult.ok();
                jsonResult.setMsg("login successfully");
                return jsonResult;
            }else {
                return JSONResult.errorMsg("incorrect password!");
            }
        }

    }

    @Override
    public Set<String> getOnlinePolices() {
        return PoliceChannelRel.getOnlinePolices();
    }
}
