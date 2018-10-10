package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.support.annotation.NonNull;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogPresenter;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogView;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogWireframe;
import com.mtlepberghenov.internship_playground.utils.TextWrapper;
import io.reactivex.Single;

public class DefaultAddDialogPresenter implements AddDialogPresenter {

  private final String TAG = this.getClass().getSimpleName();
  private final AddDialogView view;
  private final AddDialogModel model;
  private AddDialogWireframe wireframe;

  public DefaultAddDialogPresenter(AddDialogView view, AddDialogModel model,
      AddDialogWireframe defaultAddDialogWireframe) {
    this.view = view;
    this.model = model;
    wireframe = defaultAddDialogWireframe;
  }

  @Override public void onViewInitialised() {
    view.setOnAddDialogHandler(this);
  }

  @Override public void onAddBtnClicked(@NonNull SqlVehicle sqlVehicle) {

    wireframe.onClose();
  }

  @Override public void onCancelBtnClicked() {
    wireframe.onClose();
  }
}

