package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

public interface AnimalStateView {
    void setStateName(String name);

    void updateButtonState(String text, int colorID);
}
