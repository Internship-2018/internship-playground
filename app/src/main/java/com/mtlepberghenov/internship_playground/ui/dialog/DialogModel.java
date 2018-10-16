package com.mtlepberghenov.internship_playground.ui.dialog;

import com.mtlepberghenov.internship_playground.api.VehicleResponse;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.mtlepberghenov.internship_playground.ui.dialog.impl.DefaultDialogPresenter;

public interface DialogModel {

  void doPostRequest(Vehicle v, VehicleResponse response);

  void insert(Vehicle v);
}
