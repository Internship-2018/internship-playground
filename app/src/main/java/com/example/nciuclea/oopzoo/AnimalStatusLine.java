package com.example.nciuclea.oopzoo;

class AnimalStatusLine {
    private String statusName;
    private float statusRating;
    private String statusButtonName;


    public AnimalStatusLine(String statusName, float statusRating, String statusButtonName) {
        this.statusName = statusName;
        this.statusRating = statusRating;
        this.statusButtonName = statusButtonName;
    }

    public String getStatusName() {
        return statusName;
    }

    public float getStatusRating() {
        return statusRating;
    }

    public String getStatusButtonName() {
        return statusButtonName;
    }
}
