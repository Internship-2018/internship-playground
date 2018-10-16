package com.mtlepberghenov.internship_playground.api.impl;

import com.mtlepberghenov.internship_playground.api.NetworkClient;
import com.mtlepberghenov.internship_playground.api.VehicleService;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefaultNetworkClient implements NetworkClient {

  private Retrofit retrofit;

  private static DefaultNetworkClient defaultNetworkClient;

  public static DefaultNetworkClient getInstance(String baseUrl) {
    if (defaultNetworkClient == null) {
      return defaultNetworkClient = new DefaultNetworkClient(baseUrl);
    }
    return defaultNetworkClient;
  }

  private DefaultNetworkClient(String baseUrl) {
    retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getHttpClient())
        .build();
  }

  @Override public Call<List<Vehicle>> getCallVehicles() {
    return retrofit.create(VehicleService.class).getVehicles();
  }

  @Override public Call<Void> setCallVehicle(Vehicle v) {
    return retrofit.create(VehicleService.class).setVehicle(v);
  }

  private OkHttpClient getHttpClient() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return new OkHttpClient.Builder().addInterceptor(interceptor).build();
  }
}
