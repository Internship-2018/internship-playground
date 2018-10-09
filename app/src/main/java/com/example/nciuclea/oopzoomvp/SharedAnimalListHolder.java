package com.example.nciuclea.oopzoomvp;

import com.example.nciuclea.oopzoomvp.animal.Animal;
import com.example.nciuclea.oopzoomvp.animal.ExoticCat;
import com.example.nciuclea.oopzoomvp.animal.Owl;
import com.example.nciuclea.oopzoomvp.animal.Tiger;

import java.util.ArrayList;

public final class SharedAnimalListHolder {

    private static SharedAnimalListHolder instance;
    private ArrayList<Animal> animalList;


    private SharedAnimalListHolder() {
        this.animalList = new ArrayList<Animal>();
        animalList.add(new Tiger());
        animalList.add(new Owl());
        animalList.add(new ExoticCat());
    }

    public static SharedAnimalListHolder getInstance() {
        if (instance == null) {
            instance = new SharedAnimalListHolder();
        }
        return instance;
    }

    public ArrayList<Animal> getAnimalList(){ return animalList; }

}
