package com.example.nciuclea.oopzoomvp.network;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.dao.Zoopark;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ZooApiService {

    @GET("animals")
    Call<List<Animal>> getAnimals();

    @GET("zooParkList")
    Call<List<Zoopark>> getZooparks();

    @POST("animal")
    Call<Integer> addAnimal(@Body Animal animal);

    @DELETE("animal/{id}")
    Call<Integer> deleteAnimal(@Path("id") int id);
}
