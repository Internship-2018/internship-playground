package com.example.nciuclea.oopzoomvp.ZooScreen;

import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.Animal;
import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.ExoticCat;
import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.Owl;
import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.Tiger;

import java.util.ArrayList;
import java.util.List;

public class ZooModelImpl implements ZooModel {

    private ArrayList<Animal> animalList;

    public ZooModelImpl() {
        animalList = new ArrayList<Animal>();
        animalList.add(new Tiger());
        animalList.add(new Owl());
        animalList.add(new ExoticCat());
        //animalList.add(new ExoticCat());
    }

    @Override
    public List<Animal> getAnimalList() {
        return animalList;
    }
}
