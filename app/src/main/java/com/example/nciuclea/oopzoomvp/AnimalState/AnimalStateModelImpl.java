package com.example.nciuclea.oopzoomvp.AnimalState;

import java.util.Date;

public class AnimalStateModelImpl implements AnimalStateModel {
    private String stateName;
    private State state = State.GREEN;
    private Date timeLastAction = new Date(System.currentTimeMillis());
    private long changeStateTime;

    AnimalStateModelImpl(String stateName, State state, long changeStateTime){
        this.stateName = stateName;
        this.state = state;
        this.changeStateTime = changeStateTime;
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
    public Date getTimeNewState(){
        return new Date(timeLastAction.getTime() + changeStateTime);
    }


}
