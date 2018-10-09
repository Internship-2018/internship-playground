package com.example.nciuclea.oopzoomvp.ui.allanimals;

import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;

import java.util.List;

public interface AllAnimalsModel {
    void pullFromDB();

    List<DBAnimal> getAnimalsList();

    void updateAnimalState(int id, ModelUpdatedCallback callback);
}
