package com.example.nciuclea.oopzoomvp.Animal;



import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenter;

import java.util.List;

public class Animal {
    private String type;
    private int imageID;
    private List<AnimalStatePresenter> statesList;
    protected String name;

    public Animal(String type, int imageID, List<AnimalStatePresenter> statesList) {
        this.type = type;
        this.imageID = imageID;
        this.statesList = statesList;
    }

    public String getType() {
        return type;
    }

    public int getImageID() {
        return imageID;
    }

    public List<AnimalStatePresenter> getStatesList() {
        return statesList;
    }

    public void updateStates(){
        for (AnimalStatePresenter state: statesList) state.updateState();
    }
}
