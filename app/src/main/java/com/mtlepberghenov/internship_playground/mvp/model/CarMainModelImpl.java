package com.mtlepberghenov.internship_playground.mvp.model;

import com.mtlepberghenov.internship_playground.mvp.model.data.SingletonCarList;
import com.mtlepberghenov.internship_playground.mvp.model.entity.Car;

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
