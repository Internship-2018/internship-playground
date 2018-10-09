package com.mghelas.internship_playground;

import android.app.Application;

import com.mghelas.internship_playground.datasource.DbHelper;

public class App extends Application {
    private static App instance;
    private DbHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public DbHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new DbHelper(getApplicationContext());
        }
        return dbHelper;
    }
}

