package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;
import com.mtlepberghenov.internship_playground.App;
import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogPresenter;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogView;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogWireframe;
import com.mtlepberghenov.internship_playground.utils.TextWrapper;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.Subject;

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

  @SuppressLint("CheckResult")
  @Override public void onAddBtnClicked(@NonNull SqlVehicle sqlVehicle) {
    Single<SqlVehicle> single = Single.just(sqlVehicle);
    model.onWriteData(single);
  }

  @Override public void onCancelBtnClicked() {
    wireframe.onClose();
  }
}
