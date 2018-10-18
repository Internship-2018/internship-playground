package com.example.nciuclea.oopzoomvp.ui.animaldescription;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.DataUpdatedCallback;

import java.util.List;

public interface AnimalDescriptionModel {

    void pullFromDb();

    void setDataUpdatedCallback(DataUpdatedCallback<List<Animal>> dataUpdatedCallback);
}
