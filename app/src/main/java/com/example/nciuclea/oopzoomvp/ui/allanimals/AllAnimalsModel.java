package com.example.nciuclea.oopzoomvp.ui.allanimals;

import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;

import java.util.List;

public interface AllAnimalsModel {
    void pullFromDB();

    void updateAnimalState(int id);

    void setModelUpdatedCallback(ModelUpdatedCallback<List<DBAnimal>> modelUpdatedCallback);
}
