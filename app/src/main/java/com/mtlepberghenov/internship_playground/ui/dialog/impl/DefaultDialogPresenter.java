package com.mtlepberghenov.internship_playground.ui.dialog.impl;

import com.mtlepberghenov.internship_playground.api.VehicleResponse;
import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkState;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogClickHandler;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogModel;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogPresenter;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogView;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogWireframe;
import java.util.List;

public class DefaultDialogPresenter implements DialogPresenter, NetworkState, VehicleResponse {

  private DialogView view;
  private DialogModel model;
  private DialogWireframe wireframe;
  private NetworkChecker networkChecker;

  private Vehicle v;

  public DefaultDialogPresenter(DialogView view, DialogModel model,
      DialogWireframe wireframe, NetworkChecker networkChecker) {
    this.view = view;
    this.model = model;
    this.wireframe = wireframe;
    this.networkChecker = networkChecker;
  }

  @Override public void onViewInitialised() {
    view.setOnAddDialogHandler(this);
  }

  @Override public void onClickedSave(Vehicle v) {
    view.clear();
    networkChecker.check(this);
    this.v = v;
  }

  @Override public void onClickedCancel() {
    //todo wireframe close
  }

  @Override public void onlineState() {
    model.doPostRequest(v, this);
  }

  @Override public void offlineState() {
    view.showMessage();
  }

  @Override public void onResponse(List<Vehicle> vehicles) {
    model.insert(v);
  }

  @Override public void onFailure() {

  }
}
