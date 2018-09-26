package com.mtlepberghenov.internship_playground.mvp.model;

import com.mtlepberghenov.internship_playground.mvp.model.car.Car;

import java.util.ArrayList;

public class CarModel implements Model{

    private ArrayList<Car> carList;

    public CarModel() {
        this.carList = CarList.init().getList();
    }

    @Override
    public ArrayList<Car> getCarList() {
        return this.carList;
    }
}
