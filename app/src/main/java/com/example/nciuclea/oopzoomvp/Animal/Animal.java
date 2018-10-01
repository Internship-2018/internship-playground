package com.example.nciuclea.oopzoomvp.Animal;

import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenterImpl;

import java.util.List;

public class Animal {
    protected String name;
    protected String type;
    protected int imageID;
    protected List<AnimalStatePresenterImpl> statesList;

    public String getType() {
        return type;
    }

    public int getImageID() {
        return imageID;
    }

    public List<AnimalStatePresenterImpl> getStatesList() {
        return statesList;
    }

    public Animal(String type, int imageID, List<AnimalStatePresenterImpl> statesList) {
        this.type = type;
        this.imageID = imageID;
        this.statesList = statesList;
    }

    public void updateStates(){
        for (AnimalStatePresenterImpl state: statesList) state.updateState();
    }
}
