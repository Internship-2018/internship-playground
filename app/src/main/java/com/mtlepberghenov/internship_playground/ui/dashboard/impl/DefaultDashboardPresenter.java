package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.api.VehicleResponse;
import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkState;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardAdapter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;
import java.util.List;
import timber.log.Timber;

public class DefaultDashboardPresenter implements DashboardPresenter, NetworkState, VehicleResponse {

  private DashboardView view;
  private DashboardModel model;
  private DashboardAdapter adapter;
  private NetworkChecker networkChecker;

  public DefaultDashboardPresenter(DashboardView view, DashboardModel model,
      DashboardAdapter adapter, NetworkChecker networkChecker) {
    this.view = view;
    this.model = model;
    this.adapter = adapter;
    this.networkChecker = networkChecker;
  }

  @Override public void onViewInitialised() {
    view.setAdapter(adapter);
    checkNetworkState();
  }

  @Override public void offLineState() {
    Timber.d("offLineState");
    List<Vehicle>  list = model.getAllDataFromDb();
    view.updateData(list);
  }

  @Override public void onlineState() {
    Timber.d("onlineState");
    model.getListFroApi(this);
  }

  private void checkNetworkState() {
    networkChecker.check(this);
  }

  @Override public void onResponse(List<Vehicle> vehicles) {
    // FIXME: 10/15/2018
    model.insertDataIntoDb(null);
  }

  @Override public void onFailure() {

  }
}
