package com.chenfu.pojo;

import java.util.Date;
import javax.persistence.*;

public class Mession {
    @Id
    private String policeid;

    @Id
    private String driverid;

    @Column(name = "create_time")
    private Date createTime;

    public Mession() {
    }

    public Mession(String policeid, String driverid) {
        this.policeid = policeid;
        this.driverid = driverid;
    }

    /**
     * @return policeid
     */
    public String getPoliceid() {
        return policeid;
    }

    /**
     * @param policeid
     */
    public void setPoliceid(String policeid) {
        this.policeid = policeid;
    }

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
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}