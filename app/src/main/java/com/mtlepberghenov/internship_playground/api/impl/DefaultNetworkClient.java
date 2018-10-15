package com.mtlepberghenov.internship_playground.api.impl;

import com.mtlepberghenov.internship_playground.api.NetworkClient;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefaultNetworkClient implements NetworkClient {

  private static final String BASE_URL = "https://api.github.com";

  @Override public void doRequest() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getHttpClient())
        .build();

    Service service = retrofit.create(Service.class);
    Call<List<Vehicle>> call = service.list("someparam");
    // FIXME: pass call back to presenter
    call.enqueue(new Callback<List<Vehicle>>() {
      @Override public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {

      }

      @Override public void onFailure(Call<List<Vehicle>> call, Throwable t) {
        t.printStackTrace();
      }
    });
  }

  private OkHttpClient getHttpClient() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return new OkHttpClient.Builder().addInterceptor(interceptor).build();
  }
}
