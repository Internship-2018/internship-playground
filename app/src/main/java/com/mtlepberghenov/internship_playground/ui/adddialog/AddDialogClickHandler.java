package com.mtlepberghenov.internship_playground.ui.adddialog;

import com.mtlepberghenov.internship_playground.data.SqlVehicle;

public interface AddDialogClickHandler {

  void onOkBtnClicked(SqlVehicle sqlVehicle);

  void onCancelBtnClicked();
}
