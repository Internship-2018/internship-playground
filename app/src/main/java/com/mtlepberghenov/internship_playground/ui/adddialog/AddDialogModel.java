package com.mtlepberghenov.internship_playground.ui.adddialog;

import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import io.reactivex.Observable;

public interface AddDialogModel {

  void onWriteData(Observable<SqlVehicle> observable);
}
