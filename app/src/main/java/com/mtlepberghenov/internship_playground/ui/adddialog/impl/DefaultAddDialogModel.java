package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;
import com.mtlepberghenov.internship_playground.ui.adddialog.work.WorkRequest;

public class DefaultAddDialogModel implements AddDialogModel {

  private WorkRequest workRequest;

  public DefaultAddDialogModel(WorkRequest workRequest) {
    this.workRequest = workRequest;
  }

  @Override public void insertDataAsync(SqlVehicle sqlVehicle) {
    workRequest.doRequest(sqlVehicle);
  }
}