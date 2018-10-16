package com.mghelas.internship_playground.network.sweet;

import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SweetService {
    @GET("/getall")
    Call<List<Sweet>> getSweets();

    @POST("/sweet")
    Call<Void> create(@Body Sweet sweet);

    @DELETE("/sweet/{id}")
    Call<Void> deleteById(@Path("id") int id);

    @DELETE("/sweet/{confectioner_name}")
    Call<Void> deleteByConfectionerName(@Path("confectioner_name") String confectionerName);
}
