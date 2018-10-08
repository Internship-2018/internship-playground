package com.example.nciuclea.oopzoomvp.ui.allAnimals;

import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;

import java.util.List;

public interface AllAnimalsView {
    void updateData(List<DBAnimal> animalList);
}
