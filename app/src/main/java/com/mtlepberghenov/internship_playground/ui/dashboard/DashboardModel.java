package com.mtlepberghenov.internship_playground.ui.dashboard;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;

public interface DashboardModel {

  List<Vehicle> getData();

  void doRequest();
}
