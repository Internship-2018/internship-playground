package com.mtlepberghenov.internship_playground;

import android.app.Application;

import com.mtlepberghenov.internship_playground.mvp.model.CarList;

public class App extends Application {

    CarList carList = CarList.init();
}
