package com.mtlepberghenov.internship_playground.mvp.model.entity;

public class CarKitting {

    private boolean gps;
    private boolean airConditioner;

    public CarKitting(boolean gps, boolean airConditioner) {
        this.gps = gps;
        this.airConditioner = airConditioner;
    }

    public boolean isGps() {
        return gps;
    }

    public boolean isAirConditioner() {
        return airConditioner;
    }
}
