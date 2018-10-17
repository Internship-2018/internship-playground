package com.mghelas.internship_playground;

import com.mghelas.internship_playground.network.NetworkState;

public interface StartupPresenter extends NetworkState {
    void onInitialized();
}
