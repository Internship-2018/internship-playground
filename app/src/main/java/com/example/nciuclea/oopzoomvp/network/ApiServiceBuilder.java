package com.example.nciuclea.oopzoomvp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceBuilder {
    public static final String BASE_URL = "https://private-d56292-zoo3.apiary-mock.com/";

    static Retrofit getRetrofit() {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .build();
        return retrofit;
    }

    public static ZooApiService getZooApiService() {
        return getRetrofit().create(ZooApiService.class);
    }
}
