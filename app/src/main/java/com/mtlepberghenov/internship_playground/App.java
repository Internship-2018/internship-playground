package com.mtlepberghenov.internship_playground;

import android.app.Application;
import com.mtlepberghenov.internship_playground.data.SingletonCarList;

public class App extends Application {

  SingletonCarList singletonCarList = SingletonCarList.newInstance();
}
