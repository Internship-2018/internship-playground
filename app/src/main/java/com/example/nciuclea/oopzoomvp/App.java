package com.example.nciuclea.oopzoomvp;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;

public class App extends Application {

    private static App instance;
    private DatabaseHelper db;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("APP_CLASS", "App class onCreate()");
        instance = this;
        db = new DatabaseHelper(getApplicationContext());
        Intent intent = new Intent(this, StateUpdaterService.class).putExtra(StateUpdaterService.UPDATE_INTERVAL, 1000);
        startService(intent);
    }

    public static App getInstance() {
        return instance;
    }

    public DatabaseHelper getDatabaseHelper() {
        if (db == null) { db = new DatabaseHelper(getApplicationContext()); }
        return db;
    }
}
