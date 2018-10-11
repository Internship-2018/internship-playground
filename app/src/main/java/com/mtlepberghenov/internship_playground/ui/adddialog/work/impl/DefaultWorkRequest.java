package com.mtlepberghenov.internship_playground.ui.adddialog.work.impl;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.State;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;
import androidx.work.Worker;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.work.InsertDataWorker;
import com.mtlepberghenov.internship_playground.ui.adddialog.work.WorkRequest;

public class DefaultWorkRequest implements WorkRequest {

  public static final String TYPE = "type";
  public static final String MAKER = "maker";
  public static final String MODEL = "model";
  public static final String COLOR = "color";
  public static final String YEAR = "year";

  @Override
  public void doRequest(SqlVehicle sqlVehicle) {
    Data data = new Data.Builder()
        .putString(TYPE, sqlVehicle.getType())
        .putString(MAKER, sqlVehicle.getMaker())
        .putString(MODEL, sqlVehicle.getModel())
        .putString(COLOR, sqlVehicle.getColor())
        .putString(YEAR, sqlVehicle.getYear())
        .build();

    OneTimeWorkRequest insertingWork = new OneTimeWorkRequest.Builder(InsertDataWorker.class)
        .setInputData(data)
        .build();

    WorkManager.getInstance().enqueue(insertingWork);
  }
}
