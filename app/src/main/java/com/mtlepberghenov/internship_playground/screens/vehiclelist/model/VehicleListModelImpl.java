package com.mtlepberghenov.internship_playground.screens.vehiclelist.model;

import com.mtlepberghenov.internship_playground.data.SingletonCarList;
import com.mtlepberghenov.internship_playground.screens.vehiclelist.model.entity.Vehicle;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class VehicleListModelImpl implements VehicleListModel {

  @Override public Single<List<Vehicle>> getData() {
    return Observable
        .fromIterable(SingletonCarList.newInstance().getList())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .toList();
  }
}
