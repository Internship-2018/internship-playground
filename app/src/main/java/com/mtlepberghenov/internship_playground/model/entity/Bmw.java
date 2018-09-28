package com.mtlepberghenov.internship_playground.model.entity;

public class Bmw extends Car implements CarAction {

    public Bmw(String carMake, String model, String color, int year, CarKitting carKitting) {
        super(carMake, model, color, year, carKitting);
    }

    @Override
    public void switchOnEngine() {

    }

    @Override
    public void switchOffEngine() {

    }
}
