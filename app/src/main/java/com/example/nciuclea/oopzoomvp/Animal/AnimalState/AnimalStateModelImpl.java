package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

import java.util.Date;

public class AnimalStateModelImpl implements AnimalStateModel {

    private String stateName;
    private State state;
    private long changeStateTime;
    private Date timeLastAction;

    public AnimalStateModelImpl(String stateName, State state, long changeStateTime) {
        this.stateName = stateName;
        this.state = state;
        this.changeStateTime = changeStateTime;
        timeLastAction  = new Date();
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void setTimeLastAction(Date timeLastAction) {
        this.timeLastAction = timeLastAction;
    }

    @Override
    public Date getTimeNewState() {
        return new Date(timeLastAction.getTime() + changeStateTime);
    }

}
