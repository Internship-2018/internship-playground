package com.mtlepberghenov.internship_playground.service;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.mtlepberghenov.internship_playground.api.NetworkClient;
import com.mtlepberghenov.internship_playground.api.impl.DefaultNetworkClient;
import com.mtlepberghenov.internship_playground.storage.dao.DaoVehicle;
import com.mtlepberghenov.internship_playground.storage.dao.impl.DefaultDaoVehicle;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.datasource.impl.DefaultDbHelper;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultLoadDataIntentService extends IntentService {

  public static final String BASE_URL =
      "https://private-56cb57-mtlepberghenovtestapi.apiary-mock.com";
  private static final String BROADCAST_ACTION = "com.mtlepberghenov.internship_playground.bdinsertdata";

  private DaoVehicle dao;


  public DefaultLoadDataIntentService(String name) {
    super(name);
  }

  @Override public void onCreate() {
    super.onCreate();
    DbHelper dbHelper = DefaultDbHelper.getInstance(getApplicationContext());
    dao = DefaultDaoVehicle.getInstance(dbHelper);
  }

  @Override protected void onHandleIntent(@Nullable Intent intent) {

    final NetworkClient networkClient = DefaultNetworkClient.getInstance(BASE_URL);

    networkClient.getCallVehicles().enqueue(new Callback<List<Vehicle>>() {
      @Override public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
        if (response.body() != null) {
          dao.deleteAll();
          dao.insert(response.body());
          Intent i = new Intent(BROADCAST_ACTION);
          sendBroadcast(i);
        }
      }

      @Override public void onFailure(Call<List<Vehicle>> call, Throwable t) {

      }
    });
  }
}
