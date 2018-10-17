package com.example.nciuclea.oopzoomvp.ui.animaldescription.impl;

import android.view.View;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataUpdatedCallback;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionModel;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionPresenter;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionView;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionWireframe;

import java.util.List;

public class DefaultAnimalDescriptionPresenter implements AnimalDescriptionPresenter, DataUpdatedCallback<List<Animal>> {
    private final AnimalDescriptionView view;
    private final AnimalDescriptionModel defaultAnimalDescriptionModel;
    private final AnimalDescriptionWireframe defaultAnimalDescriptionWireframe;
    int animalId;

    public DefaultAnimalDescriptionPresenter(AnimalDescriptionView view,
                                             AnimalDescriptionModel defaultAnimalDescriptionModel,
                                             AnimalDescriptionWireframe defaultAnimalDescriptionWireframe,
                                             int animalId) {
        this.view = view;
        this.defaultAnimalDescriptionModel = defaultAnimalDescriptionModel;
        this.defaultAnimalDescriptionWireframe = defaultAnimalDescriptionWireframe;
        this.animalId = animalId;
    }

    @Override
    public void onViewInitialized() {
        defaultAnimalDescriptionModel.pullFromDb();
    }

    @Override
    public void onClick(View v, int id) {
        //TODO Go to Zoopark fragment
    }

    @Override
    public void onDataUpdated(List<Animal> data) {
        view.updateUI(data.get(animalId));
    }
}
