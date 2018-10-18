package com.mtlepberghenov.internship_playground.ui.dialog.impl;

import com.mtlepberghenov.internship_playground.api.VehicleResponse;
import com.mtlepberghenov.internship_playground.networking.state.NetworkChecker;
import com.mtlepberghenov.internship_playground.networking.state.NetworkState;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dialog.DialogBroadcast;
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
  private DialogBroadcast broadcast;

  private Vehicle v = new Vehicle();

  public DefaultDialogPresenter(DialogView view, DialogModel model,
      DialogWireframe wireframe, NetworkChecker networkChecker, DialogBroadcast broadcast) {
    this.view = view;
    this.model = model;
    this.wireframe = wireframe;
    this.networkChecker = networkChecker;

    this.broadcast = broadcast;
  }

  @Override public void onViewInitialised() {
    view.setOnAddDialogHandler(this);
  }

  @Override public void onClickedSave(Vehicle v) {
    this.v = new Vehicle(v);
    networkChecker.check(this);
  }

  @Override public void onClickedCancel() {
    wireframe.close();
  }

  @Override public void onlineState() {
    model.doPostRequest(v, this);
  }

  @Override public void offlineState() {
    view.showMessage();
  }

  @Override public void onResponse(List<Vehicle> vehicles) {
    model.insert(v);
    view.clear();
    broadcast.send();
  }

  @Override public void onFailure() {
    view.showMessage();
  }
}
