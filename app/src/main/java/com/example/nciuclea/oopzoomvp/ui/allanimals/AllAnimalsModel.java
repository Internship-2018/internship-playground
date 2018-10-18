package com.example.nciuclea.oopzoomvp.ui.allanimals;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;

import java.util.List;

public interface AllAnimalsModel {
    void requestData(DataUpdatedCallback<List<Animal>> dataUpdatedCallback);
}
