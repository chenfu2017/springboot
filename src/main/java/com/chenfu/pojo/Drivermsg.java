package com.chenfu.pojo;

import com.google.common.base.Objects;

import java.util.Date;
import javax.persistence.*;

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
     * @return temperature
     */
    public Integer getTemperature() {
        return temperature;
    }

    /**
     * @param temperature
     */
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    /**
     * @return humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * @param humidity
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * @return energy
     */
    public Integer getEnergy() {
        return energy;
    }

    /**
     * @param energy
     */
    public void setEnergy(Integer energy) {
        this.energy = energy;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drivermsg drivermsg = (Drivermsg) o;
        return Objects.equal(driverid, drivermsg.driverid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(driverid);
    }

    @Override
    public String toString() {
        return "Drivermsg{" +
                "driverid='" + driverid + '\'' +
                ", longtitude=" + longtitude +
                ", latitude=" + latitude +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", energy=" + energy +
                '}';
    }
}