package com.mghelas.internship_playground.start_screen.impl;

import com.mghelas.internship_playground.start_screen.StartFragment;
import com.mghelas.internship_playground.start_screen.StartPresenter;
import com.mghelas.internship_playground.start_screen.StartView;
import com.mghelas.internship_playground.start_screen.StartWireframe;

public class StartPresenterImpl implements StartPresenter {
    private StartView startView;
    private StartWireframe startWireframe;

    public StartPresenterImpl(StartView startView, StartWireframe startWireframe) {
        this.startView = startView;
        this.startWireframe = startWireframe;
    }

    @Override
    public void onViewInitialised() {
        startView.setOnStockClickHandler(this);
        startView.setOnAddClickHandler(this);
    }

    @Override
    public void onStockClicked() {
        startWireframe.showStockContent();
    }

    @Override
    public void onAddClicked() {
        startWireframe.showAddContent();
    }
}
