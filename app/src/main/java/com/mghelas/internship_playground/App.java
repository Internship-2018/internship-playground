package com.mghelas.internship_playground;

import android.app.Application;

import com.mghelas.internship_playground.network.NetworkConectivity;
import com.mghelas.internship_playground.network.NetworkConnectivityImpl;
import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.network.sweet.SweetServiceCallImpl;
import com.mghelas.internship_playground.storage.dao.impl.IngredientDaoImpl;
import com.mghelas.internship_playground.storage.dao.impl.SweetDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.IngredientDao;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;

public class App extends Application {
    private static App instance;
    StartupPresenter startupPresenter;
    StartupModel startupModel;
    SweetServiceCall sweetServiceCall;
    SweetDao sweetDao;
    IngredientDao ingredientDao;
    DbHelper dbHelper;
    NetworkConectivity networkConectivity;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dbHelper = DbHelper.getInstance(getApplicationContext());
        sweetDao = new SweetDaoImpl(dbHelper);
        ingredientDao = new IngredientDaoImpl(dbHelper);
        startupModel = new StartupModelImpl(sweetDao, ingredientDao);
        sweetServiceCall = new SweetServiceCallImpl(startupModel);
        startupModel.setSweetServiceCall(sweetServiceCall);
        networkConectivity = new NetworkConnectivityImpl();
        startupPresenter = new StartupPresenterImpl(startupModel, networkConectivity);
        startupPresenter.onInitialized();
    }

    public static App getInstance() {
        return instance;
    }

}

