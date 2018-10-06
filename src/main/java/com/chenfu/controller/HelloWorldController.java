package com.chenfu.controller;

import com.chenfu.pojo.Users;
import com.chenfu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Controller
public class HelloWorldController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String sayHello() {
        int i = 1/0;
        return "HelloWorld";
    }

    @RequestMapping("getUsers")
    @ResponseBody
    public List<Users> getUsers() {
        List<Users> users = userService.getUsers();
        return users;
    }
}
