package com.example.nciuclea.oopzoomvp;

import android.app.Application;
import android.util.Log;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("APP_CLASS", "App class onCreate()");
    }

}
