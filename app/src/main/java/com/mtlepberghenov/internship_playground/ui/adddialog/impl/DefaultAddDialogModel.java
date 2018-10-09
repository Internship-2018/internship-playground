package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.mtlepberghenov.internship_playground.App;
import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import com.mtlepberghenov.internship_playground.data.repositories.sqlite.Tables;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class DefaultAddDialogModel implements AddDialogModel {

  public static final String TAG = DefaultAddDialogModel.class.getSimpleName();
  private SQLiteDatabase db;
  private ContentValues cv;

  @Override public void onWriteData(Single<SqlVehicle> single) {
    single
        .subscribe(new SingleObserver<SqlVehicle>() {
          @Override public void onSubscribe(Disposable d) {
            Log.d(TAG, "onSubscribe: ");
            db = App.getInstance().getDbHelper().getWritableDatabase();
            cv = new ContentValues();
          }

          @Override public void onSuccess(SqlVehicle sqlVehicle) {
            Log.d(TAG, "onSuccess: ");
            cv.put(Tables.COLUMN_TYPE, sqlVehicle.getType().toString());
            cv.put(Tables.COLUMN_MODEL, sqlVehicle.getModel().toString());
            cv.put(Tables.COLUMN_COLOR, sqlVehicle.getModel().toString());
            cv.put(Tables.COLUMN_YEAR, sqlVehicle.getYear().toString());
            db.insert(Tables.TABLE_NAME, null, cv);
            db.close();
          }

          @Override public void onError(Throwable e) {
            db.close();
            Log.d(TAG, "onError: ");
          }
        });
  }
}
