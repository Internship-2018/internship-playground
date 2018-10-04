package com.example.nciuclea.oopzoomvp.ZooScreen;

import com.example.nciuclea.oopzoomvp.Animal.Animal;
import com.example.nciuclea.oopzoomvp.Animal.ExoticCat;
import com.example.nciuclea.oopzoomvp.Animal.Owl;
import com.example.nciuclea.oopzoomvp.Animal.Tiger;
import com.example.nciuclea.oopzoomvp.SharedAnimalListHolder;

import java.util.ArrayList;
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
