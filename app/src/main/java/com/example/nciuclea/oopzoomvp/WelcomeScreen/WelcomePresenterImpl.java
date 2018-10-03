package com.example.nciuclea.oopzoomvp.WelcomeScreen;

class WelcomePresenterImpl implements WelcomePresenter {

    private WelcomeFragment view;
    private WelcomeModel model;

    WelcomePresenterImpl(WelcomeFragment welcomeFragment, WelcomeModel welcomeModel) {
        this.view = welcomeFragment;
        this.model = welcomeModel;
    }

    @Override
    public void onEnterButtonClicked() {
        view.startZooView();
    }

    @Override
    public void onInitUI() {
        view.onSetZooName(model.getZooName());
        view.onSetButtonName(model.getButtonName());
    }
}
