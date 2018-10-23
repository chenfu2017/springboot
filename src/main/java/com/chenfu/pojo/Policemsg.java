package com.chenfu.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class Policemsg {
    @Id
    private String policeid;

    private Double longtitude;

    private Double latitude;

    @Column(name = "create_time")
    private Date createTime;

    public Policemsg() {
    }

    public Policemsg(String policeid, Double longtitude, Double latitude) {
        this.policeid = policeid;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Policemsg{" +
                "policeid='" + policeid + '\'' +
                ", longtitude=" + longtitude +
                ", latitude=" + latitude +
                '}';
    }
}