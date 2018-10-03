package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

import com.example.nciuclea.oopzoomvp.Animal.DeadCallback;

public interface AnimalStatePresenter {

    void setDeadCallback(DeadCallback callback);

    void onUpdateState();

    void onMasterDeath();
}
