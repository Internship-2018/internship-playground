package com.mtlepberghenov.internship_playground.api;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;
import retrofit2.Call;

public interface NetworkClient {

  Call<List<Vehicle>> getCallVehicles();

  Call<Void> setCallVehicle(Vehicle v);
}
