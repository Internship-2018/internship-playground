package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.api.NetworkClient;
import com.mtlepberghenov.internship_playground.api.VehicleResponse;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardPresenter;
import com.mtlepberghenov.internship_playground.ui.dashboard.RequestState;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultDashboardModel implements DashboardModel {

  private NetworkClient networkClient;
  private DaoVehicle dao;

  public DefaultDashboardModel(NetworkClient networkClient,DaoVehicle dao) {
    this.networkClient = networkClient;
    this.dao = dao;
  }

  @Override public void doGetRequest(RequestState requestState) {
    networkClient.getCallVehicles().enqueue(new Callback<List<Vehicle>>() {

      @Override public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
        if (response.body() != null) {
          new Thread(() -> {
            dao.deleteAll();
            dao.insert(response.body());
          }).start();

        } else {
          requestState.onFailure();
        }
      }

      @Override public void onFailure(Call<List<Vehicle>> call, Throwable t) {
        requestState.onFailure();
      }
    });

  }
}