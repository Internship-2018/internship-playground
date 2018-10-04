package com.mtlepberghenov.internship_playground;

import android.app.Application;
import com.mtlepberghenov.internship_playground.data.SingletonCarList;
import com.mtlepberghenov.internship_playground.utils.TextWrapper;

public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();

    TextWrapper.newInstance().setContext(getApplicationContext());
  }
}