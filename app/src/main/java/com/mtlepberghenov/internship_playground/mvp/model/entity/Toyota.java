package com.mtlepberghenov.internship_playground.mvp.model.entity;

public class Toyota extends Car implements CarAction {

    public Toyota(String carMake, String model, String color, int year, CarKitting carKitting) {
        super(carMake, model, color, year, carKitting);
    }

    @Override
    public void switchOnEngine() {

    }

    @Override
    public void switchOffEngine() {

    }
}
