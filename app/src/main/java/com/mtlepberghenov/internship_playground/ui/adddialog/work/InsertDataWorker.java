package com.mtlepberghenov.internship_playground.ui.adddialog.work;

import android.content.Context;
import android.support.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.mtlepberghenov.internship_playground.App;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.adddialog.work.impl.DefaultWorkRequest;
import timber.log.Timber;

public class InsertDataWorker extends Worker {

  public InsertDataWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
    super(context, workerParams);
  }

  @NonNull @Override public Result doWork() {
    SqlVehicle sqlVehicle = new SqlVehicle();
    sqlVehicle.setType(getInputData().getString(DefaultWorkRequest.TYPE));
    sqlVehicle.setMaker(getInputData().getString(DefaultWorkRequest.MAKER));
    sqlVehicle.setModel(getInputData().getString(DefaultWorkRequest.MODEL));
    sqlVehicle.setColor(getInputData().getString(DefaultWorkRequest.COLOR));
    sqlVehicle.setYear(getInputData().getString(DefaultWorkRequest.YEAR));
    App.getInstance().getDbHelper().insert(sqlVehicle);
    return Result.SUCCESS;
  }


}
