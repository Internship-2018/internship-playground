package com.mtlepberghenov.internship_playground.data;

import com.mtlepberghenov.internship_playground.model.entity.Bmw;
import com.mtlepberghenov.internship_playground.model.entity.Car;
import com.mtlepberghenov.internship_playground.model.entity.CarKitting;
import com.mtlepberghenov.internship_playground.model.entity.Toyota;

import java.util.ArrayList;

public final class SingletonCarList {

    private static SingletonCarList singletonCarList;

    private SingletonCarList() {
    }

    public static SingletonCarList init() {
        if (singletonCarList == null) {
            singletonCarList = new SingletonCarList();
        }

        return singletonCarList;
    }

    public ArrayList<Car> getList() {
        ArrayList<Car> list = new ArrayList<>();
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
