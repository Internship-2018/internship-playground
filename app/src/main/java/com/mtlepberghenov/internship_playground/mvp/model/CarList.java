package com.mtlepberghenov.internship_playground.mvp.model;

import com.mtlepberghenov.internship_playground.mvp.model.car.Bmw;
import com.mtlepberghenov.internship_playground.mvp.model.car.Car;
import com.mtlepberghenov.internship_playground.mvp.model.car.CarKitting;
import com.mtlepberghenov.internship_playground.mvp.model.car.Toyota;

import java.util.ArrayList;

public class CarList {

    private static CarList carList;

    private ArrayList<Car> list;

    private CarList() {
    }

    public static CarList init() {
        if (carList == null) {
            carList = new CarList();
        }

        return carList;
    }

    public ArrayList<Car> getList() {
        list.add(new Bmw("Bmw", "e34", "Red", 2010, new CarKitting(true, false)));
        list.add(new Bmw("Bmw", "e35", "Green", 2011, new CarKitting(true, false)));
        list.add(new Bmw("Bmw", "e36", "White", 2012, new CarKitting(false, false)));
        list.add(new Bmw("Bmw", "e37", "Black", 2013, new CarKitting(true, true)));
        list.add(new Bmw("Bmw", "e38", "Red", 2010, new CarKitting(false, false)));
        list.add(new Toyota("Toyota", "Prius1", "Grey", 2000, new CarKitting(false, false)));
        list.add(new Toyota("Toyota", "Prius2", "Black", 2005, new CarKitting(false, true)));
        list.add(new Toyota("Toyota", "Prius3", "Red", 2007, new CarKitting(true, false)));
        list.add(new Toyota("Toyota", "Prius4", "Blue", 2010, new CarKitting(true, true)));
        return list;
    }


}
