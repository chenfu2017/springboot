package com.chenfu.pojo;

import java.util.Date;
import javax.persistence.*;

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
     * @return longtitude
     */
    public Double getLongtitude() {
        return longtitude;
    }

    /**
     * @param longtitude
     */
    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    /**
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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