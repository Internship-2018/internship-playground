package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.support.annotation.NonNull;
import android.util.Log;
import com.mtlepberghenov.internship_playground.App;
import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogPresenter;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogView;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogWireframe;
import io.reactivex.Observable;

public class DefaultAddDialogPresenter implements AddDialogPresenter {

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
    Observable<SqlVehicle> observable = Observable.just(sqlVehicle);
    model.onWriteData(observable);
  }

  @Override public void onCancelBtnClicked() {
    wireframe.onClose();
  }
}
