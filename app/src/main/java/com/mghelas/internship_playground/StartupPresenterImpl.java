package com.mghelas.internship_playground;

public class StartupPresenterImpl implements StartupPresenter {

    private StartupModel startupModel;

    public StartupPresenterImpl(StartupModel startupModel) {
        this.startupModel = startupModel;
    }

    @Override
    public void updateData() {
        startupModel.updateData();
    }
}
