package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsPresenter;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsView;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsWireframe;
import com.example.nciuclea.oopzoomvp.ui.allanimals.ModelUpdatedCallback;

import java.util.List;

public class DefaultAllAnimalsPresenter implements AllAnimalsPresenter, ModelUpdatedCallback<List<Animal>> {
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
        allAnimalsModel.pullFromDB();
    }

    @Override
    public void onClick(View v, int id) {
        allAnimalsWireframe.showAnimalDescription(id);
    }

    @Override
    public void onDBUpdateReceive() {
        allAnimalsModel.pullFromDB();
    }

    @Override
    public void onModelUpdated(List<Animal> data) {
        Log.d("PROF_LOG", "got data from model");

        allAnimalsView.updateData(data);
    }
}
