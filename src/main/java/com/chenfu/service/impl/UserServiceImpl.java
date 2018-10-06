package com.chenfu.service.impl;

import com.chenfu.mapper.UsersMapper;
import com.chenfu.pojo.Users;
import com.chenfu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UsersMapper usersMapper;
    @Override
    public List<Users> getUsers() {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        List<Users> users = usersMapper.selectByExample(userExample);
        return users;
    }
}
