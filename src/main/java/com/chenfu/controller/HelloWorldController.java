package com.chenfu.controller;

import com.chenfu.pojo.JSONResult;
import com.chenfu.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public String sayHello() {
        return "HelloWorld";
    }

    @RequestMapping("/getResource")
    public JSONResult getResource() {

        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return JSONResult.ok(bean);
    }


}
