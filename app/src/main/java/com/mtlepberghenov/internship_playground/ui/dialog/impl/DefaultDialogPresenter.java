package com.mtlepberghenov.internship_playground.ui.dialog.impl;

import com.mtlepberghenov.internship_playground.ui.dialog.DialogClickHandler;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogModel;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogPresenter;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogView;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogWireframe;

public class DefaultDialogPresenter implements DialogPresenter {

  private DialogView view;
  private DialogModel model;
  private DialogWireframe wireframe;

  public DefaultDialogPresenter(DialogView view, DialogModel model, DialogWireframe wireframe) {
    this.view = view;
    this.model = model;
    this.wireframe = wireframe;
  }

  @Override public void onViewInitialised() {
    view.setOnAddDialogHandler(this);
  }
}
