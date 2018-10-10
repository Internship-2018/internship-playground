package com.mtlepberghenov.internship_playground.storage.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;

public class DbLoader extends AsyncTaskLoader<SqlVehicle> implements DataFetcher{

  public DbLoader(@NonNull Context context) {
    super(context);
  }

  @Nullable @Override public SqlVehicle loadInBackground() {
    return null;
  }

  @Override public void fetchData() {
    onContentChanged();
  }
}
