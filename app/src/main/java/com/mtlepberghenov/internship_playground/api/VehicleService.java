package com.mtlepberghenov.internship_playground.api;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface VehicleService {

  @GET("/vehicles") Call<List<Vehicle>> getVehicles();

  @POST("/vehicle")
  Call<Void> setVehicle(@Body Vehicle v);
}
