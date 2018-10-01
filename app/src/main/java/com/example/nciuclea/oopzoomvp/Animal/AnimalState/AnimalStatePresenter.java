package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

interface AnimalStatePresenter {
    void updateState();

    String getStateName();

    State getState();

    void takeAction();

    void initUI();
}
