package com.mtlepberghenov.internship_playground.mvp.model;

import com.mtlepberghenov.internship_playground.mvp.model.entity.Car;

import java.util.ArrayList;

public class CarModelImpl implements Model{

    private ArrayList<Car> carList;

    public CarModelImpl() {
        this.carList = CarList.init().getList();
    }

    @Override
    public ArrayList<Car> getCarList() {
        return this.carList;
    }
}
