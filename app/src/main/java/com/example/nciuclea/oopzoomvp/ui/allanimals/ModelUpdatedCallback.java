package com.example.nciuclea.oopzoomvp.ui.allanimals;

import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;

import java.util.List;

public interface ModelUpdatedCallback<T> {
    void onModelUpdated(T data);
}
