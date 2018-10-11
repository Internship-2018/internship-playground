package com.example.nciuclea.oopzoomvp.database;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AnimalUpdatesManager {

    private static final int POOL_SIZE = 1;
    private static final long KEEP_ALIVE_TIME = 100;

    private final ThreadPoolExecutor animalUpdatesThreadPool;
    private final BlockingQueue<Runnable> animalUpdatesQueue;
    private static AnimalUpdatesManager animalUpdatesManager;

    private static MainThreadExecutor mainThreadExecutor;

    static {
        animalUpdatesManager = new AnimalUpdatesManager();
        mainThreadExecutor = new MainThreadExecutor();
    }


    private AnimalUpdatesManager() {
        animalUpdatesQueue = new LinkedBlockingQueue<Runnable>();
        animalUpdatesThreadPool = new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, animalUpdatesQueue);
    }

    public static AnimalUpdatesManager getAnimalUpdatesManager() {
        return animalUpdatesManager;
    }

    public void runAnimalUpdate(Runnable task) {
        animalUpdatesThreadPool.execute(task);
    }

    public static MainThreadExecutor getMainThreadExecutor() {
        return mainThreadExecutor;
    }





}
