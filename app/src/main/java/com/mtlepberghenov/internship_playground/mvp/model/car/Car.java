package com.mtlepberghenov.internship_playground.mvp.model.car;

public abstract class Car {

    private String carMake;
    private String model;
    private String color;
    private int year;
    private CarKitting carKitting;

    public Car(String carMake, String model, String color, int year, CarKitting carKitting) {
        this.carMake = carMake;
        this.model = model;
        this.color = color;
        this.year = year;
        this.carKitting = carKitting;
    }
}

