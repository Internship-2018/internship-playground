package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.graphics.ColorSpace;
import android.util.Log;

import com.example.nciuclea.oopzoomvp.App;
import com.example.nciuclea.oopzoomvp.animal.state.State;
import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataFetcher;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataLoadCallback;
import com.example.nciuclea.oopzoomvp.ui.allanimals.ModelUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllAnimalsModel implements AllAnimalsModel, DataLoadCallback<List<DBAnimal>> {
    private ArrayList<DBAnimal> animalsList = new ArrayList<>();
    private final DataFetcher dataFetcher;
    private ModelUpdatedCallback<List<DBAnimal>> modelUpdatedCallback;

    public DefaultAllAnimalsModel(DataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
    }

    @Override
    public void pullFromDB() {
        Log.d("PROF_LOG", "before Model calls dataFetcher.fetchData()");
        dataFetcher.fetchData(); //Async done
    }

    @Override
    public void updateAnimalState(int id) {
        modelUpdatedCallback.onModelUpdated(new ArrayList<>(animalsList));
        for(final DBAnimal animal: animalsList) {
            if(animal.getId() == id) {
                animal.setOverallState(State.GREEN);
                animal.setTimestamp(System.currentTimeMillis());
                //db.updateAnimalState(animal); //Async
                Thread dbWriteThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        App.getInstance().getDatabaseHelper().updateAnimalState(animal);
                    }
                });
                dbWriteThread.start();
            }
        }
    }

    @Override
    public void setModelUpdatedCallback(ModelUpdatedCallback<List<DBAnimal>> modelUpdatedCallback) {
        this.modelUpdatedCallback = modelUpdatedCallback;
    }

    @Override
    public void onDataLoaded(List<DBAnimal> data) {
        animalsList = new ArrayList<>(data);
        modelUpdatedCallback.onModelUpdated(new ArrayList<>(animalsList));
    }
}
