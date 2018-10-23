package com.chenfu.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;
@Getter
@Setter
public class Drivermsg {
    @Id
    private String driverid;

    private Double longtitude;

    private Double latitude;

    private Integer temperature;

    private Integer humidity;

    private Integer energy;

    @Column(name = "create_time")
    private Date createTime;

    public Drivermsg() {
    }

    public Drivermsg(String driverid, Double longtitude, Double latitude, Integer temperature, Integer humidity, Integer energy) {
        this.driverid = driverid;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.temperature = temperature;
        this.humidity = humidity;
        this.energy = energy;
    }

}