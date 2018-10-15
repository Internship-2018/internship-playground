package com.mghelas.internship_playground;

import android.app.Application;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.network.sweet.SweetServiceCallImpl;
import com.mghelas.internship_playground.storage.dao.impl.SweetDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;

public class App extends Application {
    private static App instance;
    StartupPresenter startupPresenter;
    StartupModel startupModel;
    SweetServiceCall sweetServiceCall;
    SweetDao sweetDao;
    DbHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dbHelper = DbHelper.getInstance(getApplicationContext());
        sweetDao = new SweetDaoImpl(dbHelper);
        startupModel = new StartupModelImpl(sweetDao);
        sweetServiceCall = new SweetServiceCallImpl(startupModel);
        startupModel.setSweetServiceCall(sweetServiceCall);
        startupPresenter = new StartupPresenterImpl(startupModel);
        startupPresenter.updateData();
    }

    public static App getInstance() {
        return instance;
    }

}

