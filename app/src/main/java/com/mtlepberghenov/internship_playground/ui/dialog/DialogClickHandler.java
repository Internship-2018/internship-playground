package com.mtlepberghenov.internship_playground.ui.dialog;

import com.mtlepberghenov.internship_playground.storage.model.Vehicle;

public interface DialogClickHandler {
  void onClickedSave(Vehicle v);

  void onClickedCancel();
}
