package com.chenfu.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
public class Driver {
    @Id
    private String driverid;

    private String name;

    private Integer sex;

    private String address;

    private String carnumber;

}