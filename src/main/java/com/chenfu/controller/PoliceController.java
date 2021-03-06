package com.chenfu.controller;

import com.chenfu.pojo.Police;
import com.chenfu.pojo.Policemsg;
import com.chenfu.service.PoliceService;
import com.chenfu.service.PolicemsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/police")
public class PoliceController {

    @Autowired
    private PoliceService policeService;
    @Autowired
    private PolicemsgService policemsgService;

    @RequestMapping("/getAll")
    private List<Police> getPolices(){
        List<Police> polices = policeService.getPolices();
        return polices;
    }

    @RequestMapping("/showOnline")
    private Set<String> getOnlinePolices() {
        return policeService.getOnlinePolices();
    }

    @RequestMapping("/getMsg")
    private List<Policemsg> getOnlinePolicemsg(){
        return policemsgService.getOnlinePolicemsg();
    }
}
