package com.mtlepberghenov.internship_playground.ui.welcome.impl;

import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeModel;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomePresenter;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeView;
import com.mtlepberghenov.internship_playground.ui.welcome.WelcomeWireFrame;

public class DefaultWelcomePresenter implements WelcomePresenter {

  private final WelcomeView view;
  private final WelcomeModel welcomeModel;
  private final WelcomeWireFrame welcomeWireFrame;

  public DefaultWelcomePresenter(WelcomeView view, WelcomeModel welcomeModel, WelcomeWireFrame welcomeWireFrame) {

    this.view = view;
    this.welcomeModel = welcomeModel;
    this.welcomeWireFrame = welcomeWireFrame;
  }

  @Override public void onViewInitialised() {
    view.setOnWelcomeHandler(this);
  }

  @Override public void onShowBtnClicked() {
    welcomeWireFrame.showMainContent();
  }

  @Override public void onAddBtnClicked() {
    welcomeWireFrame.showAddContent();
  }
}
