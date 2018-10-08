package com.mtlepberghenov.internship_playground.ui.list.impl;

import com.mtlepberghenov.internship_playground.data.SingletonCarList;
import com.mtlepberghenov.internship_playground.ui.list.entity.Vehicle;
import com.mtlepberghenov.internship_playground.ui.list.ListModel;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class DefaultListModel implements ListModel {

  @Override public Single<List<Vehicle>> getData() {
    return Observable
        .fromIterable(SingletonCarList.newInstance().getList())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .toList();
  }
}
