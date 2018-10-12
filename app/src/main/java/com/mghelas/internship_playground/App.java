package com.mghelas.internship_playground;

import android.app.Application;

import com.mghelas.internship_playground.datasource.DbHelper;

public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

}

