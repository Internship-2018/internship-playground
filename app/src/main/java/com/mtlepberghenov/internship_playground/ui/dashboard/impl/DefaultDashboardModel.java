package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import java.util.List;

public class DefaultDashboardModel implements DashboardModel {

  private DaoVehicle dao;

  public DefaultDashboardModel(DaoVehicle dao) {
    this.dao = dao;
  }

  @Override public List<Vehicle> getData() {
    return dao.selectAll();
  }

  @Override public void doRequest() {

  }
}
