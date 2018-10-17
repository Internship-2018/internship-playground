package com.mghelas.internship_playground;

import com.mghelas.internship_playground.network.NetworkConectivity;

public class StartupPresenterImpl implements StartupPresenter {

    private StartupModel startupModel;
    private NetworkConectivity networkConectivity;

    public StartupPresenterImpl(StartupModel startupModel, NetworkConectivity networkConectivity) {
        this.startupModel = startupModel;
        this.networkConectivity = networkConectivity;
    }

    @Override
    public void onInitialized() {
        if (networkConectivity.isNetworkConnected()) {
            isOnline();
        } else {
            isOffline();
        }
    }

    @Override
    public void isOnline() {
        startupModel.updateData();
    }

    @Override
    public void isOffline() {
    }
}
