package com.mghelas.internship_playground.network.sweet;

import com.mghelas.internship_playground.StartupModel;
import com.mghelas.internship_playground.network.APIUtils;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SweetServiceCallImpl implements SweetServiceCall {

    private StartupModel startupModel;

    public SweetServiceCallImpl(StartupModel startupModel) {
        this.startupModel = startupModel;
    }

    @Override
    public void getAll() {
        final List<Sweet> sweets = new ArrayList<>();
        SweetService service = APIUtils.getSweetService();
        Call<List<Sweet>> callAsync = service.getSweets();

        callAsync.enqueue(new Callback<List<Sweet>>() {
            @Override
            public void onResponse(Call<List<Sweet>> call, Response<List<Sweet>> response) {

                sweets.addAll(response.body());

                startupModel.syncDb(sweets);
            }

            @Override
            public void onFailure(Call<List<Sweet>> call, Throwable throwable) {
                System.out.println(throwable);
//                startupModel.onApiFailure(throwable);
            }
        });
    }

    @Override
    public void create(Sweet sweet) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteByConfectionerName(String confectionerName) {

    }
}
