package com.mtlepberghenov.internship_playground.storage.loader.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import com.mtlepberghenov.internship_playground.storage.loader.DataLoadCallBack;
import com.mtlepberghenov.internship_playground.storage.loader.DbLoader;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import java.util.List;

public class DefaultDbLoaderCallback implements LoaderManager.LoaderCallbacks<List<SqlVehicle>> {

  private final DataLoadCallBack<List<SqlVehicle>> dataLoadCallBack;
  private final DbLoader dbLoader;

  public DefaultDbLoaderCallback(DataLoadCallBack<List<SqlVehicle>> dataLoadCallBack, DbLoader dbLoader) {
    this.dataLoadCallBack = dataLoadCallBack;
    this.dbLoader = dbLoader;
  }

  @NonNull @Override
  public Loader<List<SqlVehicle>> onCreateLoader(int i, @Nullable Bundle bundle) {
    return dbLoader;
  }

  @Override public void onLoadFinished(@NonNull Loader<List<SqlVehicle>> loader,
      List<SqlVehicle> sqlVehicles) {
    dataLoadCallBack.onDataLoaded(sqlVehicles);

  }

  @Override public void onLoaderReset(@NonNull Loader<List<SqlVehicle>> loader) {

  }
}
