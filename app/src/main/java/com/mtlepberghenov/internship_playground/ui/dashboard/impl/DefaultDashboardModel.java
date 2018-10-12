package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;

public class DefaultDashboardModel implements DashboardModel {

  private DbHelper dbHelper;

  public DefaultDashboardModel(DbHelper dbHelper) {
    this.dbHelper = dbHelper;
  }
}
