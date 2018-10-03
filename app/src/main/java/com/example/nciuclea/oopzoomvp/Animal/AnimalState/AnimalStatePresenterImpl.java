package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

import com.example.nciuclea.oopzoomvp.Animal.DeadCallback;
import com.example.nciuclea.oopzoomvp.R;

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
    public void onInitUI() {
        if(viewIsSet) {
            view.setStateName(model.getStateName());
            changeState(model.getState());
        }
    }

    @Override
    public void onUpdateState() {
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
    public void onTakeAction() {
        //method sets the state to maximal one if animal is alive
        if (model.isMasterAlive()) changeState(State.GREEN);
    }

    @Override
    public void onMasterDeath() {
        model.setMasterIsDead();
        changeState(State.BLACK);
    }

    private void changeState(State state) {
        model.setState(state);
        model.setTimeLastAction(new Date());
        String text = "UNDEFINED";
        int colorID = R.color.black;
        switch (state) {
            case GREEN:
                text = "GOOD";
                colorID = R.color.green;
                break;
            case YELLOW:
                text = "OK";
                colorID = R.color.yellow;
                break;
            case RED:
                text = "BAD";
                colorID = R.color.red;
                break;
            case BLACK:
                text = "DEAD";
                colorID = R.color.black;
                break;
        }
        view.updateButtonState(text, colorID);
    }
}
