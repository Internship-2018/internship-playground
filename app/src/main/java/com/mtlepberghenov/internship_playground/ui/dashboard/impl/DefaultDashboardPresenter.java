package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardAdapter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;

public class DefaultDashboardPresenter implements DashboardPresenter {

  private DashboardView view;
  private DashboardModel model;
  private DashboardAdapter adapter;

  public DefaultDashboardPresenter(DashboardView view, DashboardModel model, DashboardAdapter adapter) {
    this.view = view;
    this.model = model;
    this.adapter = adapter;
  }

  @Override public void onViewInitialised() {
    view.setAdapter(adapter);
  }
}
