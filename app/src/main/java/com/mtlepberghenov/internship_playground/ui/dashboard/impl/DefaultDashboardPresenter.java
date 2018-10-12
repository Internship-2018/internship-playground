package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkState;
import com.mtlepberghenov.internship_playground.storage.model.Data;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardAdapter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;
import java.util.List;
import timber.log.Timber;

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

  @Override public void offLineState() {
    Timber.d("offLineState");
    //List<Data>  list = model.getData();
    //view.updateData(list);
  }

  @Override public void onLineState() {
    Timber.d("onLineState");
    //todo do a request
    //todo load data from the db
  }

  private void checkNetworkState() {
    networkChecker.check(this);
  }
}
