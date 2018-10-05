package com.mghelas.internship_playground.start_screen.presenter;

import com.mghelas.internship_playground.start_screen.view.StartFragment;

public class StartPresenterImpl implements StartPresenterIntf {
    private StartFragment startFragment;

    public StartPresenterImpl(StartFragment startFragment) {
        this.startFragment = startFragment;
    }

    @Override
    public void onStockClick() {
        startFragment.stock();
    }

    @Override
    public void onAddClick() {
        startFragment.add();
    }
}
