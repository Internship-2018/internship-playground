package com.mtlepberghenov.internship_playground.ui.adddialog;

import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import io.reactivex.Single;

public interface AddDialogModel {

  void onWriteData(Single<SqlVehicle> single);
}