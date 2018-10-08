package com.mtlepberghenov.internship_playground;

import android.app.Application;
import com.mtlepberghenov.internship_playground.utils.TextWrapper;

public class App extends Application {

  private static App instance;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;

    TextWrapper.newInstance().setContext(getApplicationContext());

  }

  public static App getInstance() {
    return instance;
  }
}