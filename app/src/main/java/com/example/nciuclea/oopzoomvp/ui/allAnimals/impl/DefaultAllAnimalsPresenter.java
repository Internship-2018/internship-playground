package com.example.nciuclea.oopzoomvp.ui.allAnimals.impl;

import android.view.View;

import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.AllAnimalsPresenter;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.AllAnimalsView;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.AllAnimalsWireframe;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.ModelUpdatedCallback;

import java.util.List;

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
