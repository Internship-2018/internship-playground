package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkState;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardAdapter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;
import com.mtlepberghenov.internship_playground.ui.dashboard.RequestState;
import java.util.List;

public class DefaultDashboardPresenter
    implements DashboardPresenter, NetworkState, RequestState {

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

  @Override public void offlineState() {
    List<Vehicle> list = model.loadData();
    view.updateData(list);
  }

  @Override public void onlineState() {
    model.doGetRequest(this);
  }

  @Override public void onResponse() {
    List<Vehicle> list = model.loadData();
    view.updateData(list);
  }

  @Override public void onFailure() {
    view.showMessage();
  }

  private void checkNetworkState() {
    networkChecker.check(this);
  }
}