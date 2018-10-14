package com.mghelas.internship_playground.network;

import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SweetCall {
    public static void main(String[] args) {

        SweetService service = APIUtils.getSweetService();
        Call<List<Sweet>> callAsync = service.getSweets(5, 1);

        callAsync.enqueue(new Callback<List<Sweet>>() {
            @Override
            public void onResponse(Call<List<Sweet>> call, Response<List<Sweet>> response) {

                List<Sweet> sweets = response.body();
                System.out.println(sweets.toString());
            }

            @Override
            public void onFailure(Call<List<Sweet>> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });
    }
}
