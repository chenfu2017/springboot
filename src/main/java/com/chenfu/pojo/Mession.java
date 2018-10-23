package com.chenfu.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;
@Getter
@Setter
public class Mession {
    @Id
    private String policeid;

    @Id
    private String driverid;

    private Boolean finish;

    @Column(name = "create_time")
    private Date createTime;

    public Mession() {
    }

    public Mession(String policeid, String driverid) {
        this.policeid = policeid;
        this.driverid = driverid;
    }
}