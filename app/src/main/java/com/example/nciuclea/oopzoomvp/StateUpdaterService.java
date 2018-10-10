package com.example.nciuclea.oopzoomvp;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import com.example.nciuclea.oopzoomvp.animal.state.State;
import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class StateUpdaterService extends Service {

    private DatabaseHelper db;
    private Handler refreshHandler;
    public final static String BROADCAST_ACTION = "com.example.nciuclea.oopzoomvp.bdupdatedbroadcast";
    public final static String UPDATE_INTERVAL = "UPDATE_INTERVAL";
    private long updateInterval;

    class UpdateDBTimerTask extends TimerTask {
        @Override
        public void run() {
            for (DBAnimal animal : db.getAllAnimals()) {
                if(updateAnimalState(animal)) {
                    db.updateAnimalState(animal);
                }
            }
            Intent intent = new Intent(BROADCAST_ACTION);
            sendBroadcast(intent);
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
        db = App.getInstance().getDatabaseHelper();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        updateInterval = intent.getLongExtra(UPDATE_INTERVAL, 1000);
        Timer updateBDTimer = new Timer();
        updateBDTimer.schedule(new UpdateDBTimerTask(), updateInterval, updateInterval);
        return super.onStartCommand(intent, flags, startId);
    }

    boolean updateAnimalState(DBAnimal animal) {
        Date lastUpdated = new Date(animal.getTimestamp()+animal.getStateTransitionTime());
        if (new Date().after(lastUpdated)) {
            switch (animal.getOverallState()) {
                case GREEN:
                    animal.setOverallState(State.YELLOW);
                    break;
                case YELLOW:
                    animal.setOverallState(State.RED);
                    break;
                case RED:
                    animal.setOverallState(State.BLACK);
                    break;
            }
            animal.setTimestamp(System.currentTimeMillis());
            return true;
        }
        return false;
    }

    @Override
    public void onDestroy() {

    }

    //@androidx.annotation.Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
