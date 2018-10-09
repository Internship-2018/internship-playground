package com.mtlepberghenov.internship_playground.ui.list.impl;

import com.mtlepberghenov.internship_playground.ui.list.ListModel;
import com.mtlepberghenov.internship_playground.ui.list.ListPresenter;
import com.mtlepberghenov.internship_playground.ui.list.ListView;
import com.mtlepberghenov.internship_playground.data.entites.sql.Vehicle;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.List;

public class DefaultListPresenter implements ListPresenter {

  private final ListView listView;
  private final ListModel listModel;

  public DefaultListPresenter(ListView listView, ListModel listModel) {
    this.listView = listView;
    this.listModel = listModel;
  }

  @Override public void onViewInitialised() {
    getData();
  }

  private void getData() {
    listModel.getData()
        .subscribe(new SingleObserver<List<Vehicle>>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onSuccess(List<Vehicle> vehicles) {
            listView.setData(vehicles);
          }

          @Override public void onError(Throwable e) {

          }
        });
  }
}
