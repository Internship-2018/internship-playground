package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardView;

public class DefaultDashboardPresenter implements DashboardPresenter {

  private DashboardView view;
  private DashboardModel model;

  public DefaultDashboardPresenter(DashboardView view, DashboardModel model) {
    this.view = view;
    this.model = model;
  }

  @Override public void onViewInitialised() {

  }
}
