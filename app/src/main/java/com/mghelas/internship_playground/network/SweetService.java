package com.mghelas.internship_playground.network;

import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SweetService {
    @GET("/sweets")
    public Call<List<Sweet>> getSweets(
            @Query("per_page") int per_page,
            @Query("page") int page);

    @GET("/sweets/{title}")
    public Call<Sweet> getUser(@Path("title") String title);
}
