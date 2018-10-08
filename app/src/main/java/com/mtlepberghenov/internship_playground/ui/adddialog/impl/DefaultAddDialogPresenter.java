package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogPresenter;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogView;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogWireframe;
import io.reactivex.functions.Consumer;

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

  @Override public void onOkBtnClicked(SqlVehicle sqlVehicle) {
    // TODO: 09.10.2018 check data there or v pojo
    model.onWriteData(sqlVehicle);
  }

  @Override public void onCancelBtnClicked() {
    wireframe.onClose();
  }
}
