package com.example.nciuclea.oopzoomvp.ui.allAnimals.impl;

import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.AllAnimalsModel;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.ModelUpdatedCallback;

import java.util.ArrayList;
import java.util.List;

public class DefaultAllAnimalsModel implements AllAnimalsModel {
    private ArrayList<DBAnimal> animalsList = new ArrayList<>();
    private DatabaseHelper db;

    public DefaultAllAnimalsModel(DatabaseHelper db) {
        this.db = db;
    }

    @Override
    public void pullFromDB() {
        animalsList.clear();
        animalsList.addAll(db.getAllAnimals());
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
                db.updateAnimalState(animal);
            }
        }
        callback.onModelUpdated();
    }
}
