package com.mtlepberghenov.internship_playground.ui.list.loader.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.list.loader.DataDbLoadCallBack;
import com.mtlepberghenov.internship_playground.ui.list.loader.DbDataLoader;
import java.util.List;

public class DefaultDbLoaderCallback implements LoaderManager.LoaderCallbacks<List<SqlVehicle>> {

  private final DataDbLoadCallBack<List<SqlVehicle>> dataDbLoadCallBack;
  private final DbDataLoader dbDataLoader;

  public DefaultDbLoaderCallback(DbDataLoader dbDataLoader,
      DataDbLoadCallBack<List<SqlVehicle>> dataDbLoadCallBack) {
    this.dbDataLoader = dbDataLoader;
    this.dataDbLoadCallBack = dataDbLoadCallBack;
  }

  @NonNull @Override
  public Loader<List<SqlVehicle>> onCreateLoader(int i, @Nullable Bundle bundle) {
    return dbDataLoader;
  }

  @Override public void onLoadFinished(@NonNull Loader<List<SqlVehicle>> loader,
      List<SqlVehicle> sqlVehicles) {
    dataDbLoadCallBack.onDataLoaded(sqlVehicles);
  }

  @Override public void onLoaderReset(@NonNull Loader<List<SqlVehicle>> loader) {

  }
}
