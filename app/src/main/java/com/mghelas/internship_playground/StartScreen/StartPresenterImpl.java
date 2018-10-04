package com.mghelas.internship_playground.StartScreen;

public class StartPresenterImpl implements StartPresenterIntf {
    private StartFragment startFragment;

    public StartPresenterImpl(StartFragment startFragment) {
        this.startFragment = startFragment;
    }

    @Override
    public void viewStock() {
        startFragment.goToStock();
    }
}
