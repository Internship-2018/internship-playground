package com.mghelas.internship_playground.ui.startscreen.impl;

import com.mghelas.internship_playground.ui.startscreen.StartPresenter;
import com.mghelas.internship_playground.ui.startscreen.StartView;
import com.mghelas.internship_playground.ui.startscreen.StartWireframe;

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
