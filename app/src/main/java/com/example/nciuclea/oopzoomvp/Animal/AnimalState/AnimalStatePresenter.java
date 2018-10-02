package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

import com.example.nciuclea.oopzoomvp.Animal.DeadCallback;

public interface AnimalStatePresenter {
    boolean isViewSet();

    void setView(AnimalStateView view);

    void setDeadCallback(DeadCallback callback);

    void initUI();

    void updateState();

    void takeAction();

    void notifyMasterIsDead();
}
