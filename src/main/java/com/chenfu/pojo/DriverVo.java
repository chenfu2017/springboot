package com.chenfu.pojo;

public class DriverVo {
    private String driverid;

    private Double longtitude;

    private Double latitude;

    private Integer temperature;

    private Integer humidity;

    private Integer energy;

    public DriverVo(String driverid, Double longtitude, Double latitude, Integer temperature, Integer humidity, Integer energy) {
        this.driverid = driverid;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.temperature = temperature;
        this.humidity = humidity;
        this.energy = energy;
    }

    public DriverVo() {

    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }
}
