package com.chenfu.controller;

import com.chenfu.pojo.Police;
import com.chenfu.service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/police")
public class PoliceController {

    @Autowired
    private PoliceService policeService;

    @RequestMapping("/getAll")
    private List<Police> getPolices(){
        List<Police> polices = policeService.getPolices();
        return polices;
    }
}