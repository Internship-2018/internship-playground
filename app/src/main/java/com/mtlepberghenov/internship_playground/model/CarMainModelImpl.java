package com.mtlepberghenov.internship_playground.model;

import com.mtlepberghenov.internship_playground.data.SingletonCarList;
import com.mtlepberghenov.internship_playground.model.entity.Vehicle;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class CarMainModelImpl implements MainModel {

  private ArrayList<Vehicle> carList;

  public CarMainModelImpl() {
    this.carList = SingletonCarList.newInstance().getList();
  }

  @Override public ArrayList<Vehicle> getVehicleList() {
    return this.carList;
  }

  @Override public Single<List<Vehicle>> getData() {
    return Observable
        .fromIterable(SingletonCarList.newInstance().getList())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .toList();
  }
}
