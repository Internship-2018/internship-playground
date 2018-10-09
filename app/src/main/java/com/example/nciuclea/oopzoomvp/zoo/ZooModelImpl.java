package com.example.nciuclea.oopzoomvp.zoo;

import com.example.nciuclea.oopzoomvp.animal.Animal;
import com.example.nciuclea.oopzoomvp.SharedAnimalListHolder;

import java.util.List;

public class ZooModelImpl implements ZooModel {

    private List<Animal> animalList;

    public ZooModelImpl() {
        this.animalList = SharedAnimalListHolder.getInstance().getAnimalList();
    }

    @Override
    public List<Animal> getAnimalList() {
        return animalList;
    }
}
