package com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState;

import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.DeadCallback;

public interface AnimalStatePresenter {

    void setDeadCallback(DeadCallback callback);

    void onUpdateState();

    void onMasterDeath();
}
