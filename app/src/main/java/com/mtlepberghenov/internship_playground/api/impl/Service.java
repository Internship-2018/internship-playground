package com.mtlepberghenov.internship_playground.api.impl;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
  // FIXME: when will be api

  @GET("") Call<List<Vehicle>> list(String param);
}
