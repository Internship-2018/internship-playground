package com.example.nciuclea.oopzoomvp.Animal.AnimalState;

import com.example.nciuclea.oopzoomvp.R;

import java.util.Date;

public class AnimalStatePresenterImpl implements AnimalStatePresenter {

    AnimalStateModel model;
    AnimalStateView view;

    public AnimalStatePresenterImpl(AnimalStateModel model) {
        this.model = model;
    }

    public AnimalStatePresenterImpl(AnimalStateModel model, AnimalStateView view) {
        this.model = model;
        this.view = view;
    }

    public void setView(AnimalStateView view) {
        this.view = view;
    }

    @Override
    public void updateState() {
        if(new Date(System.currentTimeMillis())
                .after(model.getTimeNewState())){
            switch (model.getState()) {
                case GREEN:
                    model.setState(State.YELLOW);
                    view.updateStateButton(State.YELLOW);
                    break;
                case YELLOW:
                    model.setState(State.RED);
                    view.updateStateButton(State.RED);
                    break;
                case RED:
                    model.setState(State.BLACK);
                    view.updateStateButton(State.BLACK);
                    break;
            }
            model.setTimeLastAction(new Date());
        }
    }

    @Override
    public String getStateName() {
        return model.getStateName();
    }

    @Override
    public State getState() {
        return model.getState();
    }

    @Override
    public void takeAction() {
        model.setTimeLastAction(new Date());
        model.setState(State.GREEN);
        view.changeStateButtonName(State.GREEN);
        view.changeStateButtonColor(State.GREEN);
    }

    @Override
    public void initUI() {
        view.setStateName(model.getStateName());
        view.changeStateButtonName(model.getState());
        view.changeStateButtonColor(model.getState());
    }
}
