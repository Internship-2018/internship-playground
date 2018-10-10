package com.mtlepberghenov.internship_playground.storage.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import java.util.List;

public class DbLoader extends AsyncTaskLoader<List<SqlVehicle>> implements DataFetcher{

  public DbLoader(@NonNull Context context) {
    super(context);
  }

  @Nullable @Override public List<SqlVehicle> loadInBackground() {
    // TODO: 10/10/2018 Load data from db
    return null;
  }

  @Override public void fetchData() {
    onContentChanged();
  }
}
