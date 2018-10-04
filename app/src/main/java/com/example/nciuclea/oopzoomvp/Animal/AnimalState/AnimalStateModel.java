package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

import java.util.Date;

public interface AnimalStateModel {

    String getStateName();

    State getState();

    void setState(State state);

    void setTimeLastAction(Date timeLastAction);

    Date getTimeNewState();

    boolean isMasterAlive();

    void setMasterIsDead();
}
