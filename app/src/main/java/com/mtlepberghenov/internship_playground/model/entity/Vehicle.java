package com.mtlepberghenov.internship_playground.model.entity;

public abstract class Vehicle {
    private String type;
    private String carMake;
    private String model;
    private String color;
    private int year;

    public Vehicle(String type, String carMake, String model, String color, int year) {
        this.type = type;
        this.carMake = carMake;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }
}
