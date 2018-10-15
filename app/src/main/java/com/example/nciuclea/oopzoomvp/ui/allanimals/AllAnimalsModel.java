package com.example.nciuclea.oopzoomvp.ui.allanimals;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;

import java.util.List;

public interface AllAnimalsModel {
    void pullFromDB();

    void setModelUpdatedCallback(ModelUpdatedCallback<List<Animal>> modelUpdatedCallback);
}
