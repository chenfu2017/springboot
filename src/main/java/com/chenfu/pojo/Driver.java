package com.chenfu.pojo;

public class Driver {

    private String driverId;

    private double longtitude;

    private double latitude;

    private int  temperature;

    private int humidity;

    private int energy;

    public Driver() {

    }

    public Driver(String driverId, double longtitude, double latitude, int temperature, int humidity, int energy) {
        this.driverId = driverId;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.temperature = temperature;
        this.humidity = humidity;
        this.energy = energy;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
