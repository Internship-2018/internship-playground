package com.mtlepberghenov.internship_playground.ui.dashboard;

import com.mtlepberghenov.internship_playground.api.VehicleResponse;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;

public interface DashboardModel {

  void insertDataIntoDb(Vehicle v);

  List<Vehicle> getAllDataFromDb();

  void deleteDataFromDb(Vehicle v);

  void getListFroApi(VehicleResponse response);

}
