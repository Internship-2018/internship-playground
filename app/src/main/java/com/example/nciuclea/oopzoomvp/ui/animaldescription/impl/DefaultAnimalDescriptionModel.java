package com.example.nciuclea.oopzoomvp.ui.animaldescription.impl;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataUpdatedCallback;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionModel;
import com.example.nciuclea.oopzoomvp.util.loaders.DataFetcher;
import com.example.nciuclea.oopzoomvp.util.loaders.DataLoadCallback;

import java.util.ArrayList;
import java.util.List;

public class DefaultAnimalDescriptionModel implements AnimalDescriptionModel, DataLoadCallback<List<Animal>> {
    private final DataFetcher dataFetcher;
    private DataUpdatedCallback<List<Animal>> dataUpdatedCallback;

    public DefaultAnimalDescriptionModel(DataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    @Override
    public void pullFromDb() {
        dataFetcher.fetchData();
    }

    @Override
    public void setDataUpdatedCallback(DataUpdatedCallback<List<Animal>> dataUpdatedCallback) {
        this.dataUpdatedCallback = dataUpdatedCallback;
    }

    @Override
    public void onDataLoaded(List<Animal> data) {
        dataUpdatedCallback.onDataUpdated(new ArrayList<Animal>(data));
    }
}
