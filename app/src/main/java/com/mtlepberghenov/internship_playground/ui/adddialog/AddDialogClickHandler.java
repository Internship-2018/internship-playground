package com.mtlepberghenov.internship_playground.ui.adddialog;

import android.support.annotation.NonNull;
import com.mtlepberghenov.internship_playground.data.SqlVehicle;

public interface AddDialogClickHandler {

  void onAddBtnClicked(@NonNull SqlVehicle sqlVehicle);

  void onCancelBtnClicked();
}
