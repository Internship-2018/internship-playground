package com.example.nciuclea.oopzoomvp.ui.allAnimals.impl;

import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allAnimals.AllAnimalsModel;

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
}
