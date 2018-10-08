package com.chenfu.pojo;

public class Coordinate {

    private String id;
    private double longtitude;
    private double latitude;

    public Coordinate() {

    }

    public Coordinate(String id, double longtitude, double latitude) {
        this.id = id;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
