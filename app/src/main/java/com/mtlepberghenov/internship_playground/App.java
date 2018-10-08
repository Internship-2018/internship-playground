package com.mtlepberghenov.internship_playground;

import android.app.Application;
import com.mtlepberghenov.internship_playground.data.repositories.sqlite.DbHelper;

public class App extends Application {

  private static App instance;
  private DbHelper db;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
  }

  public static App getInstance() {
    return instance;
  }

  public DbHelper getDbHelper() {
    if (db == null) {
      db = new DbHelper(getApplicationContext());
    }
    return db;
  }
}