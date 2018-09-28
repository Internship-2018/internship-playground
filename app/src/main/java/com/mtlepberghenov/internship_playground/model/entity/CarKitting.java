package com.mtlepberghenov.internship_playground.model.entity;

public class CarKitting {

    private boolean gps;
    private boolean airConditioner;

    public CarKitting(boolean gps, boolean airConditioner) {
        this.gps = gps;
        this.airConditioner = airConditioner;
    }

    public String getGps() {
        return String.valueOf(gps);
    }

    public String getAirConditioner() {
        return String.valueOf(airConditioner);
    }
}
