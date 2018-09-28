package com.example.nciuclea.oopzoomvp.WelcomeScreen;

import android.view.View;

class WelcomePresenterImpl implements WelcomePresenter {

    WelcomeFragment view;
    WelcomeModel model;

    public WelcomePresenterImpl(WelcomeFragment welcomeFragment, WelcomeModel welcomeModel) {
        this.view = welcomeFragment;
        this.model = welcomeModel;
    }

    @Override
    public void onEnterButtonClicked() {
        view.startZooFragment();
    }

    @Override
    public void onUICreated() {
        view.onSetZooName(model.getZooName());
        view.onSetButtonName(model.getButtonName());
    }
}
