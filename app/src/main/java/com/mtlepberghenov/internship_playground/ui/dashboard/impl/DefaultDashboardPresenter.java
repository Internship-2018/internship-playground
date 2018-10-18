package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkState;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardAdapter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardBroadcastReceiver;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;
import com.mtlepberghenov.internship_playground.ui.dashboard.DataChangeHandler;
import com.mtlepberghenov.internship_playground.ui.dashboard.RequestState;
import java.util.List;
import timber.log.Timber;

public class DefaultDashboardPresenter
    implements DashboardPresenter, NetworkState, RequestState, DataChangeHandler {

  private DashboardView view;
  private DashboardModel model;
  private DashboardAdapter adapter;
  private NetworkChecker networkChecker;
  private DashboardBroadcastReceiver broadcastReceiver;

  public DefaultDashboardPresenter(DashboardView view, DashboardModel model,
      DashboardAdapter adapter, NetworkChecker networkChecker,
      DashboardBroadcastReceiver broadcastReceiver) {
    this.view = view;
    this.model = model;
    this.adapter = adapter;
    this.networkChecker = networkChecker;
    this.broadcastReceiver = broadcastReceiver;
  }

  @Override public void onViewInitialised() {
    view.setAdapter(adapter);
    view.setRefreshHandler(this);
    broadcastReceiver.setDataChangeHandler(this);
    checkNetworkState();
  }

  @Override public void onRefresh() {
    checkNetworkState();
  }

  @Override public void onlineState() {
    model.doGetRequest(this);
  }

  @Override public void offlineState() {
    List<Vehicle> list = model.loadData();
    view.updateData(list);
    view.setRefreshingFalse();
    view.showMessage(R.string.offline_1);
  }

  @Override public void onResponse() {
    List<Vehicle> list = model.loadData();
    view.updateData(list);
    view.setRefreshingFalse();
  }

  @Override public void onFailure() {
    view.setRefreshingFalse();
    view.showMessage(R.string.server_error);
  }

  @Override public void onDataChanged() {
    Timber.d("onDataChanged");
    view.updateData(model.loadData());
  }

  private void checkNetworkState() {
    networkChecker.check(this);
  }
}