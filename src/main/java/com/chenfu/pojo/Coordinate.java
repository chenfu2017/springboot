package com.chenfu.pojo;

import java.util.Date;
import javax.persistence.*;

public class Coordinate {
    @Id
    private String id;

    private Double longtitude;

    private Double latitude;

    public Coordinate() {
    }

    public Coordinate(String id, Double longtitude, Double latitude) {
        this.id = id;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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