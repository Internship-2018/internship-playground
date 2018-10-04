package com.mtlepberghenov.internship_playground.data;

import com.mtlepberghenov.internship_playground.model.entity.Car;
import com.mtlepberghenov.internship_playground.model.entity.Motorcycle;
import com.mtlepberghenov.internship_playground.model.entity.Ship;
import com.mtlepberghenov.internship_playground.model.entity.Vehicle;
import java.util.ArrayList;

public final class SingletonCarList {

  private static SingletonCarList singletonCarList;

  private SingletonCarList() {
    //Private constructor
  }

  public static SingletonCarList newInstance() {
    if (singletonCarList == null) {
      singletonCarList = new SingletonCarList();
    }

    return singletonCarList;
  }

  public ArrayList<Vehicle> getList() {
    ArrayList<Vehicle> list = new ArrayList<>();
    list.add(new Car("Car", "Toyota", "Prius", "Red", 2010));
    list.add(new Car("Car", "BMW", "e34", "White", 2013));
    list.add(new Car("Car", "Mercedes", "C300", "Black", 2000));
    list.add(new Motorcycle("MotorCycle", "Yamaha", "SS-45", "Brown", 1999));
    list.add(new Ship("Ship", "USA", "Bill", "Blue", 1985));
    return list;
  }
}
