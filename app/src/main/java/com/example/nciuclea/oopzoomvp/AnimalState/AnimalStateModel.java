package com.example.nciuclea.oopzoomvp.AnimalState;

import java.util.Date;

interface AnimalStateModel {

    State getState();

    void setState(State state);

    void setTimeLastAction(Date timeLastAction);

    Date getTimeNewState();
}
