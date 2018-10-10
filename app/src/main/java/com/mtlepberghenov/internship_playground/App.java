package com.mtlepberghenov.internship_playground;

import android.app.Application;
import com.mtlepberghenov.internship_playground.storage.sql.DbHelper;
import com.mtlepberghenov.internship_playground.utils.TextWrapper;

public class App extends Application {

  private static App instance;
  private DbHelper db;
  private TextWrapper tw;

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

  public TextWrapper getTextWrapper() {
    if (tw == null) {
      tw = new TextWrapper();
    }
    return tw;
  }
}