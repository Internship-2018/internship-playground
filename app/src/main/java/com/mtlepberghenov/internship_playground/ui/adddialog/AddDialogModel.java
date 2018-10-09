package com.mtlepberghenov.internship_playground.ui.adddialog;

import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.impl.CallBack;
import io.reactivex.Single;

public interface AddDialogModel {

  void onWriteData(Single<SqlVehicle> single,
      CallBack callBack);
}