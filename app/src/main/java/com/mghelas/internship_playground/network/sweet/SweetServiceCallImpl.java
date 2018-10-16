package com.mghelas.internship_playground.network.sweet;

import com.mghelas.internship_playground.StartupModel;
import com.mghelas.internship_playground.network.APIUtils;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddModel;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedModel;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SweetServiceCallImpl implements SweetServiceCall {

    private StartupModel startupModel;
    private SweetAddModel sweetAddModel;
    private SweetDetailedModel sweetDetailedModel;
    private SweetListModel sweetListModel;

    public SweetServiceCallImpl(StartupModel startupModel) {
        this.startupModel = startupModel;
    }

    public SweetServiceCallImpl(SweetAddModel sweetAddModel) {
        this.sweetAddModel = sweetAddModel;
    }

    public SweetServiceCallImpl(SweetDetailedModel sweetDetailedModel) {
        this.sweetDetailedModel = sweetDetailedModel;
    }

    public SweetServiceCallImpl(SweetListModel sweetListModel) {
        this.sweetListModel = sweetListModel;
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
    public void create(final Sweet sweet) {
        SweetService service = APIUtils.getSweetService();
        Call<Void> callAsync = service.create(sweet);
        callAsync.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {


                sweetAddModel.onCreateCalled(sweet);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                System.out.println(throwable);
//                startupModel.onApiFailure(throwable);
            }
        });

    }

    @Override
    public void deleteById(final int id) {
        SweetService service = APIUtils.getSweetService();
        Call<Void> callAsync = service.deleteById(id);

        callAsync.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                sweetDetailedModel.onRemoveCalled(id);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteByConfectionerName(final String confectionerName) {
        SweetService service = APIUtils.getSweetService();
        Call<Void> callAsync = service.deleteByConfectionerName(confectionerName);

        callAsync.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                sweetListModel.onDeleteCalled(confectionerName);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
