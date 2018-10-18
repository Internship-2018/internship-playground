package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.util.Log;
import android.view.View;

import com.example.nciuclea.oopzoomvp.network.NetworkError;
import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsPresenter;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsView;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsWireframe;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataUpdatedCallback;
import com.example.nciuclea.oopzoomvp.ui.allanimals.ApiResponseReceivedCallback;

import java.io.IOException;
import java.util.List;

public class DefaultAllAnimalsPresenter implements AllAnimalsPresenter, DataUpdatedCallback<List<Animal>> {
    private final AllAnimalsView allAnimalsView;
    private final AllAnimalsModel allAnimalsModel;
    private final AllAnimalsWireframe allAnimalsWireframe;


    public DefaultAllAnimalsPresenter(DefaultAllAnimalsView view, AllAnimalsModel model, AllAnimalsWireframe wireframe) {
        this.allAnimalsView = view;
        this.allAnimalsModel = model;
        this.allAnimalsWireframe = wireframe;
    }

    @Override
    public void onViewInitialized() {
        Log.d("PROF_LOG", "requested data from model in presenter / onViewInitialized");
        allAnimalsModel.requestData(this);
    }

    @Override
    public void onDataUpdated(List<Animal> data) {
        Log.d("PROF_LOG", "got data from model");
        allAnimalsView.updateData(data);
    }

    @Override
    public void onDataFetchError(NetworkError error){
        allAnimalsView.showNetworkError(error.getMsg());
    }

    @Override
    public void onClick(View v, int id) {
        allAnimalsWireframe.showAnimalDescription(id);
    }
}
