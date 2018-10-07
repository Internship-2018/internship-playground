package com.mtlepberghenov.internship_playground.ui.start.impl;

import com.mtlepberghenov.internship_playground.ui.start.StartPresenter;
import com.mtlepberghenov.internship_playground.ui.start.StartWireFrame;

public class DefaultStartPresenter implements StartPresenter {

  private final StartWireFrame startWireFrame;

  public DefaultStartPresenter(StartWireFrame startWireFrame) {
    this.startWireFrame = startWireFrame;
  }

  @Override public void onViewInitialised() {
    startWireFrame.showStartContent();
  }
}
