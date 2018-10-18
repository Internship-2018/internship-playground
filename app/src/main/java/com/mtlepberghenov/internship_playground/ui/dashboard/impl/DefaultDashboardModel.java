package com.mtlepberghenov.internship_playground.ui.dashboard.impl;

import com.mtlepberghenov.internship_playground.api.NetworkClient;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dashboard.DashboardModel;
import com.mtlepberghenov.internship_playground.ui.dashboard.RequestState;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultDashboardModel implements DashboardModel {

  private NetworkClient networkClient;
  private DaoVehicle dao;

  public DefaultDashboardModel(NetworkClient networkClient, DaoVehicle dao) {
    this.networkClient = networkClient;
    this.dao = dao;
  }

  @Override public void doGetRequest(RequestState requestState) {
    networkClient.getCallVehicles().enqueue(new Callback<List<Vehicle>>() {

      @Override public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
        if (response.body() != null) {
          ExecutorService es = Executors.newSingleThreadExecutor();
          Runnable r = () -> {
            dao.deleteAll();
            dao.insert(response.body());
          };

          try {
            es.submit(r).get();
            es.shutdown();
            requestState.onResponse();
          } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
          }

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
    ExecutorService es = Executors.newSingleThreadExecutor();
    Callable<List<Vehicle>> c = () -> dao.selectAll();
    Future<List<Vehicle>> f = es.submit(c);
    try {
      List<Vehicle> list = f.get();
      es.shutdown();

      return list;

    } catch (ExecutionException | InterruptedException e) {
      es.shutdown();
      e.printStackTrace();

      return new ArrayList<>();
    }
  }
}