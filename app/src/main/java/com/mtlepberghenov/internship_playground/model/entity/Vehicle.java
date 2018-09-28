package com.mtlepberghenov.internship_playground.model.entity;

public abstract class Vehicle {
    private String carMake;
    private String model;
    private String color;
    private String type;
    private int year;

    public Vehicle(String carMake, String model, String color, String type, int year) {
        this.carMake = carMake;
        this.model = model;
        this.color = color;
        this.type = type;
        this.year = year;
    }
}
