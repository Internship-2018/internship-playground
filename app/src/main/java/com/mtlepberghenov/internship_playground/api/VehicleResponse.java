package com.mtlepberghenov.internship_playground.api;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;

public interface VehicleResponse {

  void onResponse(List<Vehicle> vehicles);

  void onFailure();
}
