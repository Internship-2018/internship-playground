package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.util.Log;
import android.view.View;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsPresenter;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsView;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsWireframe;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataUpdatedCallback;
import com.example.nciuclea.oopzoomvp.ui.allanimals.ApiResponseReceivedCallback;

import java.util.List;

public class DefaultAllAnimalsPresenter implements AllAnimalsPresenter, DataUpdatedCallback<List<Animal>>, ApiResponseReceivedCallback<List<Animal>> {
    private final AllAnimalsView allAnimalsView;
    private final AllAnimalsModel allAnimalsModel;
    private final AllAnimalsWireframe allAnimalsWireframe;
    private boolean apiFetched = false;

    public DefaultAllAnimalsPresenter(DefaultAllAnimalsView view, AllAnimalsModel model, AllAnimalsWireframe wireframe) {
        this.allAnimalsView = view;
        this.allAnimalsModel = model;
        this.allAnimalsWireframe = wireframe;
    }

    @Override
    public void onViewInitialized() {
        Log.d("PROF_LOG", "requested data from model in presenter / onViewInitialized");
        if(apiFetched){
            allAnimalsModel.pullFromDB();
        } else{
            allAnimalsModel.pullFromApi();
            apiFetched = true;
        }
    }

    @Override
    public void onSuccess(List<Animal> data) {
        allAnimalsModel.pullFromDB();
    }

    @Override
    public void onFailure() {
        allAnimalsView.showNetworkError("API request failed, trying to get last saved data...");
        allAnimalsModel.pullFromDB();
    }

    @Override
    public void onDataUpdated(List<Animal> data) {
        Log.d("PROF_LOG", "got data from model");
        allAnimalsView.updateData(data);
    }

    @Override
    public void onClick(View v, int id) {
        allAnimalsWireframe.showAnimalDescription(id);
    }
}
