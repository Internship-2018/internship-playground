package com.mtlepberghenov.internship_playground;

import android.app.Application;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.datasource.impl.DefaultDbHelper;
import timber.log.Timber;

public class App extends Application {

  private static App instance;
  private DefaultDbHelper dbHelper;

  @Override public void onCreate() {
    super.onCreate();
    Timber.plant(new Timber.DebugTree());

    instance = this;
  }

  public static App getInstance() {
    return instance;
  }

  // FIXME: if it's possible. I'm had to context for DbHelper
  public DefaultDbHelper getDbHelper() {
    if (dbHelper == null) {
      dbHelper = new DefaultDbHelper(getApplicationContext());
    }
    return dbHelper;
  }
}