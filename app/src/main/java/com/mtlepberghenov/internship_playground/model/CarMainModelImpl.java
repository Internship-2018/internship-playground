package com.mtlepberghenov.internship_playground.model;

import com.mtlepberghenov.internship_playground.data.SingletonCarList;
import com.mtlepberghenov.internship_playground.model.entity.Car;

import com.mtlepberghenov.internship_playground.model.entity.Vehicle;
import java.util.ArrayList;

public class CarMainModelImpl implements MainModel {

    private ArrayList<Vehicle> carList;

    public CarMainModelImpl() {
        this.carList = SingletonCarList.init().getList();
    }

    @Override
    public ArrayList<Vehicle> getVehicleList() {
        return this.carList;
    }
}
