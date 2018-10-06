package com.chenfu.service.impl;

import com.chenfu.mapper.UsersMapper;
import com.chenfu.pojo.Users;
import com.chenfu.pojo.UsersExample;
import com.chenfu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UsersMapper usersMapper;
    @Override
    public List<Users> getUsers() {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users;
    }
}
