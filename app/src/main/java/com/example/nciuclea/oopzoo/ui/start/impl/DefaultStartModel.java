package com.example.nciuclea.oopzoo.ui.start.impl;

import com.example.nciuclea.oopzoo.storage.model.Animal;
import com.example.nciuclea.oopzoo.ui.start.DataFetcher;
import com.example.nciuclea.oopzoo.ui.start.DataLoadCallback;
import com.example.nciuclea.oopzoo.ui.start.StartModel;

import java.util.List;


public class DefaultStartModel implements StartModel, DataLoadCallback<List<Animal>> {

    private final DataFetcher dataFetcher;

    public DefaultStartModel(DataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    @Override
    public void getData() {
        dataFetcher.fetchData();
    }

    @Override
    public void onDataLoaded(List<Animal> data) {
        //TODO call presenter method.
    }

}
