package com.chenfu.pojo;

import javax.persistence.*;

public class Driver {
    @Id
    private String driverid;

    private Integer temperature;

    private Integer humidity;

    private Integer energy;

    public Driver() {
    }

    public Driver(String driverid, Integer temperature, Integer humidity, Integer energy) {
        this.driverid = driverid;
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
}