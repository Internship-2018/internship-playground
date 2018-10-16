package com.mtlepberghenov.internship_playground;

import android.app.Application;
import android.content.Intent;
import com.mtlepberghenov.internship_playground.service.DefaultLoadDataIntentService;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.datasource.impl.DefaultDbHelper;
import timber.log.Timber;

public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Timber.plant(new Timber.DebugTree());
    Intent intent = new Intent(getApplicationContext(), DefaultLoadDataIntentService.class);
    startService(intent);
  }
}