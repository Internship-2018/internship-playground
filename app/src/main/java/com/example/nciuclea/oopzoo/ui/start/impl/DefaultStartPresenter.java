package com.example.nciuclea.oopzoo.ui.start.impl;

import com.example.nciuclea.oopzoo.ui.start.StartModel;
import com.example.nciuclea.oopzoo.ui.start.StartPresenter;
import com.example.nciuclea.oopzoo.ui.start.StartView;
import com.example.nciuclea.oopzoo.ui.start.StartWireframe;


public class DefaultStartPresenter implements StartPresenter {

    private final StartView startView;
    private final StartModel startModel;
    private final StartWireframe startWireframe;

    public DefaultStartPresenter(StartView startView, StartModel startModel, StartWireframe startWireframe) {
        this.startView = startView;
        this.startModel = startModel;
        this.startWireframe = startWireframe;
    }

    @Override
    public void onViewInitialised() {
        startView.setOnStarClickHandler(this);
    }

    @Override
    public void onStartClicked() {
        startWireframe.showMainContent();
    }
}
