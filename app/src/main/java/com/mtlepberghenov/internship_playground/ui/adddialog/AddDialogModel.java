package com.mtlepberghenov.internship_playground.ui.adddialog;

import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;

public interface AddDialogModel {

  void insertDataAsync(SqlVehicle sqlVehicle);
}