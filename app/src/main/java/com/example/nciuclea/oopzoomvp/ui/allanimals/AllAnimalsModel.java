package com.example.nciuclea.oopzoomvp.ui.allanimals;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;

import java.util.List;

public interface AllAnimalsModel {
    void pullFromDB();

    void setDataUpdatedCallback(DataUpdatedCallback<List<Animal>> dataUpdatedCallback);

    void pullFromApi();
}
