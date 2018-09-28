package com.mtlepberghenov.internship_playground.model;

import com.mtlepberghenov.internship_playground.data.SingletonCarList;
import com.mtlepberghenov.internship_playground.model.entity.Car;

import java.util.ArrayList;

public class CarMainModelImpl implements MainModel {

    private ArrayList<Car> carList;

    public CarMainModelImpl() {
        this.carList = SingletonCarList.init().getList();
    }

    @Override
    public ArrayList<Car> getCarList() {
        return this.carList;
    }
}
