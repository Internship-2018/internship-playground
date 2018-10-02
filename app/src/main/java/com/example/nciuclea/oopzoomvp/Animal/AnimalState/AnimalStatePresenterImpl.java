package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

import com.example.nciuclea.oopzoomvp.Animal.DeadCallback;

import java.util.Date;

public class AnimalStatePresenterImpl implements AnimalStatePresenter {

    private AnimalStateModel model;
    private AnimalStateView view;
    private boolean viewIsSet;
    private DeadCallback deadCallback;

    public AnimalStatePresenterImpl(AnimalStateModel model) {
        this.model = model;
        this.viewIsSet = false;
    }

    @Override
    public boolean isViewSet() {
        return viewIsSet;
    }

    @Override
    public void setView(AnimalStateView view) {
        this.view = view;
        this.viewIsSet = true;
    }

    @Override
    public void setDeadCallback(DeadCallback callback) { this.deadCallback = callback; }

    @Override
    public void initUI() {
        if(viewIsSet) {
            view.setStateName(model.getStateName());
            view.changeStateButtonName(model.getState());
            view.changeStateButtonColor(model.getState());
        }
    }

    @Override
    public void updateState() {
        //method lowers the state if changeStateTime has passed
        if (new Date(System.currentTimeMillis())
                .after(model.getTimeNewState()) && viewIsSet && model.isMasterAlive()) {
            switch (model.getState()) {
                case GREEN:
                    changeState(State.YELLOW);
                    break;
                case YELLOW:
                    changeState(State.RED);
                    break;
                case RED:
                    deadCallback.die();
                    break;
            }
        }
    }

    @Override
    public void takeAction() {
        //method sets the state to maximal one if animal is alive
        if (model.isMasterAlive()) changeState(State.GREEN);
    }

    @Override
    public void notifyMasterIsDead() {
        model.notifyMasterIsDead();
        changeState(State.BLACK);
    }

    private void changeState(State state) {
        model.setState(state);
        model.setTimeLastAction(new Date());
        view.updateStateButton(state);
    }
}
