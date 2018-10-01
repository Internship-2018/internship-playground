package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

public interface AnimalStateView {
    void setStateName(String name);

    void updateStateButton(State state);

    void changeStateButtonName(State state);

    void changeStateButtonColor(State state);
}
