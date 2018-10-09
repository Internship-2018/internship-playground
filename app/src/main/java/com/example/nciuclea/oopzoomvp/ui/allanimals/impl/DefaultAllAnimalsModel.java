package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import com.example.nciuclea.oopzoomvp.animal.state.State;
import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allanimals.ModelUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllAnimalsModel implements AllAnimalsModel {
    private ArrayList<DBAnimal> animalsList = new ArrayList<>();
    private DatabaseHelper db;

    public DefaultAllAnimalsModel(DatabaseHelper db) {
        this.db = db;
    }

    @Override
    public void pullFromDB(ModelUpdatedCallback callback) {
        List<DBAnimal> newAnimalsList = db.getAllAnimals(); //Async
        animalsList.clear();
        animalsList.addAll(newAnimalsList);
        callback.onModelUpdated();
    }

    @Override
    public List<DBAnimal> getAnimalsList() {
        return animalsList;
    }

    @Override
    public void updateAnimalState(int id, ModelUpdatedCallback callback) {
        for(DBAnimal animal: animalsList) {
            if(animal.getId() == id) {
                animal.setOverallState(State.GREEN);
                animal.setTimestamp(System.currentTimeMillis());
                db.updateAnimalState(animal); //Async
            }
        }
        callback.onModelUpdated();
    }
}
