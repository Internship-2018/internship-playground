package com.example.nciuclea.oopzoomvp.Animal;



import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenter;

import java.util.List;

public class Animal implements DeadCallback {
    private String type;
    private int imageID;
    private List<AnimalStatePresenter> statesList;
    protected String name;

    private boolean isAlive = true;

    public Animal(String type, int imageID, List<AnimalStatePresenter> statesList) {
        this.type = type;
        this.imageID = imageID;
        this.statesList = statesList;
        for (AnimalStatePresenter state: statesList) state.setDeadCallback(this);
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

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void die(){
        isAlive = false; //will be used for stopping states updates on certain animal
        for (AnimalStatePresenter state: statesList) state.notifyMasterIsDead();
    }
}
