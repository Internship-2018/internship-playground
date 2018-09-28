package com.example.nciuclea.oopzoomvp.AnimalState;

import java.util.Date;

public class AnimalStatePresenterImpl implements AnimalStatePresenter {

    AnimalStateModel model = new AnimalStateModelImpl();
    AnimalStateView view = new AnimalStateViewImpl();

    @Override
    public void updateState() {
        if(new Date(System.currentTimeMillis())
                .after(model.getTimeNewState())){
            switch (model.getState()) {
                case GREEN:
                    model.setState(State.YELLOW);
                    view.changeButtonColor(State.YELLOW);
                    break;
                case YELLOW:
                    model.setState(State.RED);
                    view.changeButtonColor(State.RED);
                    break;
                case RED:
                    model.setState(State.BLACK);
                    view.changeButtonColor(State.BLACK);
                    break;
            }
        }
    }

    @Override
    public void takeAction() {
        model.setTimeLastAction(new Date());
        model.setState(State.GREEN);
        view.changeButtonColor(State.GREEN);
    }
}
