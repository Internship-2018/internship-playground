package com.example.nciuclea.oopzoomvp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TimeService extends Service {

    public int onStartCommand(Intent intent, int flags, int startId) {
        updaterTask();
        return super.onStartCommand(intent, flags, startId);
    }


    //@androidx.annotation.Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    void updaterTask() {

    }
}
