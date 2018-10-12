package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkState;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardAdapter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;

public class DefaultDashboardPresenter implements DashboardPresenter, NetworkState {

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

  private void checkNetworkState() {
    networkChecker.check(this);
  }

  @Override public void offLineState(){
    model.getData();
    //todo load data from the db
  }

  @Override public void onLineState() {
    //todo do a request
    //todo load data from the db
  }
}
