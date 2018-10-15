package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.util.Log;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataFetcher;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataLoadCallback;
import com.example.nciuclea.oopzoomvp.ui.allanimals.ModelUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllAnimalsModel implements AllAnimalsModel, DataLoadCallback<List<Animal>> {
    private ArrayList<Animal> animalsList = new ArrayList<>();
    private final DataFetcher dataFetcher;
    private ModelUpdatedCallback<List<Animal>> modelUpdatedCallback;

    public DefaultAllAnimalsModel(DataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    @Override
    public void pullFromDB() {
        Log.d("PROF_LOG", "before Model calls dataFetcher.fetchData()");
        dataFetcher.fetchData();
    }

    @Override
    public void setModelUpdatedCallback(ModelUpdatedCallback<List<Animal>> modelUpdatedCallback) {
        this.modelUpdatedCallback = modelUpdatedCallback;
    }

    @Override
    public void onDataLoaded(List<Animal> data) {
        animalsList = new ArrayList<>(data);
        modelUpdatedCallback.onModelUpdated(new ArrayList<>(animalsList));
    }
}
