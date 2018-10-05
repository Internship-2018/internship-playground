package com.example.nciuclea.oopzoomvp.Animal;



import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateModel;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenter;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;

import java.util.List;

public class Animal implements DeadCallback {
    private String type;
    private int imageID;
    private AnimalStatePresenter presenter;
    private List<AnimalStateModel> statesList;

    private State generalState;

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

    public State getGeneralState() {
        return generalState;
    }

    public void setGeneralState(State generalState) {
        this.generalState = generalState;
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
