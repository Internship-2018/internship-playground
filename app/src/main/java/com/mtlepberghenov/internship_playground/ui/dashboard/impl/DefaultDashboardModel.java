package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.api.NetworkClient;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.RequestState;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultDashboardModel implements DashboardModel {

  private static final int N_THREADS = 3;
  private NetworkClient networkClient;
  private DaoVehicle dao;
  private ExecutorService executorService;

  public DefaultDashboardModel(NetworkClient networkClient, DaoVehicle dao) {
    this.networkClient = networkClient;
    this.dao = dao;
  }

  @Override public void doGetRequest(RequestState requestState) {
    networkClient.getCallVehicles().enqueue(new Callback<List<Vehicle>>() {

      @Override public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
        if (response.body() != null) {
          dao.deleteAll();
          dao.insert(response.body());
          requestState.onResponse();
        } else {
          requestState.onFailure();
        }
      }

      @Override public void onFailure(Call<List<Vehicle>> call, Throwable t) {
        requestState.onFailure();
      }
    });
  }

  @Override public List<Vehicle> loadData() {
    return dao.selectAll();
  }
}