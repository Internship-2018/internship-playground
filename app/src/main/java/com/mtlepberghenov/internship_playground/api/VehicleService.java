package com.mtlepberghenov.internship_playground.api;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface VehicleService {

  @GET("vehicles") Call<List<Vehicle>> getVehicles();
}
