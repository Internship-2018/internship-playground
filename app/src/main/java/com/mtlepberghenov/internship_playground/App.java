package com.mtlepberghenov.internship_playground;

import android.app.Application;

import com.mtlepberghenov.internship_playground.mvp.model.data.SingletonCarList;

public class App extends Application {

    SingletonCarList singletonCarList = SingletonCarList.init();
}
