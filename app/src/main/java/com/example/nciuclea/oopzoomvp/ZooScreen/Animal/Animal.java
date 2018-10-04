package com.example.nciuclea.oopzoomvp.ZooScreen.Animal;



import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState.AnimalStateModel;
import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState.AnimalStatePresenter;

import java.util.List;

public class Animal implements DeadCallback {
    private String type;
    private int imageID;
    private AnimalStatePresenter presenter;
    private List<AnimalStateModel> statesList;
    protected String name;
    private boolean isAlive = true;

    public Animal(String type, int imageID, List<AnimalStateModel> statesList) {
        this.type = type;
        this.imageID = imageID;
        this.statesList = statesList;
    }

    public void setPresenter(AnimalStatePresenter presenter) {
        this.presenter = presenter;
    }

    public String getType() {
        return type;
    }

    public int getImageID() {
        return imageID;
    }

    public List<AnimalStateModel> getStatesList() {
        return statesList;
    }

    public void updateStates(){
        presenter.onUpdateState();
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void die(){
        isAlive = false; //will be used for stopping states updates on certain animal
        presenter.onMasterDeath();
    }
}
