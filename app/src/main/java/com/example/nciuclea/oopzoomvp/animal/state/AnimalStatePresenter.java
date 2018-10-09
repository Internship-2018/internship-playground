package com.example.nciuclea.oopzoomvp.animal.state;

import com.example.nciuclea.oopzoomvp.animal.DeadCallback;

public interface AnimalStatePresenter {

    void setDeadCallback(DeadCallback callback);

    void onUpdateState();

    void onMasterDeath();
}
