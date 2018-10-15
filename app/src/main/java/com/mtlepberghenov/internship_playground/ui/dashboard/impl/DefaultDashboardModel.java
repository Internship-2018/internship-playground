package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashboardModel implements DashboardModel {

  @Override public List<Vehicle> getData() {
    //todo go to data base and return data
    return new ArrayList<>();
  }

  @Override public void doRequest() {

  }
}
