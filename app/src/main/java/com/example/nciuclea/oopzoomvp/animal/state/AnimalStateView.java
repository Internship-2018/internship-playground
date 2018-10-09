package com.example.nciuclea.oopzoomvp.animal.state;

public interface AnimalStateView {
    void setStateName(String name);

    void updateButtonState(String text, int colorID);
}
