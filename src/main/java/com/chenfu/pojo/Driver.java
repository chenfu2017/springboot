package com.chenfu.pojo;

import javax.persistence.*;

public class Driver {
    @Id
    private String driverid;

    private String name;

    private Integer sex;

    private String address;

    private String carnumber;

    /**
     * @return driverid
     */
    public String getDriverid() {
        return driverid;
    }

    /**
     * @param driverid
     */
    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return carnumber
     */
    public String getCarnumber() {
        return carnumber;
    }

    /**
     * @param carnumber
     */
    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }
}