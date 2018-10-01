package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

public interface AnimalStatePresenter {
    boolean isViewSet();

    void setView(AnimalStateView view);

    void initUI();

    void updateState();

    void takeAction();
}
