package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import com.mtlepberghenov.internship_playground.App;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModelCallBack;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;

public class DefaultAddDialogModel implements AddDialogModel {

  private AddDialogModelCallBack modelHandler;

  @Override public void insertData(SqlVehicle sqlVehicle, AddDialogModelCallBack callBack) {
    App.getInstance().getDbHelper().insert(sqlVehicle, callBack);
  }


}