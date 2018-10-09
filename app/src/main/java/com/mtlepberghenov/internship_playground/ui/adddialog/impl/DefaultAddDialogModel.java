package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import com.mtlepberghenov.internship_playground.App;
import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import com.mtlepberghenov.internship_playground.data.repositories.sqlite.DbHelper;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;

public class DefaultAddDialogModel implements AddDialogModel {

  private DbHelper db;

  @Override public void onWriteData(SqlVehicle sqlVehicle) {
     db = App.getInstance().getDbHelper();
  }
}
