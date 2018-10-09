package com.chenfu.pojo;

public class TakeAction {

    private String policeId;

    private String driverId;

    public TakeAction() {

    }

    public TakeAction(String policeId, String driverId) {
        this.policeId = policeId;
        this.driverId = driverId;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}
