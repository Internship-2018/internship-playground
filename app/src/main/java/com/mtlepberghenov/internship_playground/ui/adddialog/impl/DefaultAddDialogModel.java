package com.mtlepberghenov.internship_playground.ui.adddialog.impl;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.mtlepberghenov.internship_playground.App;
import com.mtlepberghenov.internship_playground.data.SqlVehicle;
import com.mtlepberghenov.internship_playground.data.repositories.sqlite.DbHelper;
import com.mtlepberghenov.internship_playground.data.repositories.sqlite.Tables;
import com.mtlepberghenov.internship_playground.ui.adddialog.AddDialogModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DefaultAddDialogModel implements AddDialogModel {

  public static final String TAG = DefaultAddDialogModel.class.getSimpleName();
  private SQLiteDatabase db;
  private ContentValues cv;

  @SuppressLint("CheckResult")
  @Override public void onWriteData(Observable<SqlVehicle> observable) {
     observable
         .subscribeOn(AndroidSchedulers.mainThread())
         .observeOn(Schedulers.io())
         .subscribe(new Observer<SqlVehicle>() {
           @Override public void onSubscribe(Disposable d) {

           }

           @Override public void onNext(SqlVehicle sqlVehicle) {
             db = App.getInstance().getDbHelper().getWritableDatabase();
             cv = new ContentValues();
             cv.put(Tables.COLUMN_TYPE, sqlVehicle.getType().toString());
             cv.put(Tables.COLUMN_MODEL, sqlVehicle.getModel().toString());
             cv.put(Tables.COLUMN_COLOR, sqlVehicle.getModel().toString());
             cv.put(Tables.COLUMN_YEAR, sqlVehicle.getYear().toString());
             db.insert(Tables.TABLE_NAME, null, cv);
           }

           @Override public void onError(Throwable e) {
             Log.d(TAG, "onError: ");
           }

           @Override public void onComplete() {
             Log.d(TAG, "onComplete: ");
           }
         });
  }
}
