package com.example.nciuclea.oopzoomvp.ZooScreen;

import com.example.nciuclea.oopzoomvp.Animal.Animal;
import com.example.nciuclea.oopzoomvp.Animal.ExoticCat;
import com.example.nciuclea.oopzoomvp.Animal.Owl;
import com.example.nciuclea.oopzoomvp.Animal.Tiger;

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
