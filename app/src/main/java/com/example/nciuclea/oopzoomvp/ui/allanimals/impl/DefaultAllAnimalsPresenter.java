package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.view.View;

import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsPresenter;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsView;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsWireframe;
import com.example.nciuclea.oopzoomvp.ui.allanimals.ModelUpdatedCallback;

public class DefaultAllAnimalsPresenter implements AllAnimalsPresenter, ModelUpdatedCallback {
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
        allAnimalsModel.pullFromDB();
        allAnimalsView.updateData(allAnimalsModel.getAnimalsList());
    }

    @Override
    public void onClick(View v, int id) {
        allAnimalsModel.updateAnimalState(id, this);
    }

    @Override
    public void onModelUpdated() {
        allAnimalsView.updateData(allAnimalsModel.getAnimalsList());
    }
}
