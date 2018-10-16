package com.mtlepberghenov.internship_playground.ui.dialog.impl;

import com.mtlepberghenov.internship_playground.api.NetworkClient;
import com.mtlepberghenov.internship_playground.api.VehicleResponse;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class DefaultDialogModel implements DialogModel {

  private NetworkClient networkClient;
  private DaoVehicle dao;

  public DefaultDialogModel(NetworkClient networkClient, DaoVehicle dao) {
    this.networkClient = networkClient;
    this.dao = dao;
  }

  @Override public void doPostRequest(Vehicle v, VehicleResponse vehicleResponse) {
    networkClient.setCallVehicle(v).enqueue(new Callback<Vehicle>() {

      @Override public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
        if (response.isSuccessful()) {
          vehicleResponse.onResponse(null);
          Timber.d("response isSuccessful");
        } else {
          vehicleResponse.onFailure();
          Timber.d("response isn't successful");
        }
      }

      @Override public void onFailure(Call<Vehicle> call, Throwable t) {
        t.printStackTrace();
        Timber.d("onFailure");
        vehicleResponse.onFailure();
      }
    });
  }

  @Override public void insert(Vehicle v) {
    dao.insert(v);
  }
}
