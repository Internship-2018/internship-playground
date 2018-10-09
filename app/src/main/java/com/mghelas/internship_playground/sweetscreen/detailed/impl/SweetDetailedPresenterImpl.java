package com.mghelas.internship_playground.sweetscreen.detailed.impl;


import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedPresenter;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedModel;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedView;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedWireframe;

public class SweetDetailedPresenterImpl implements SweetDetailedPresenter {
    private SweetDetailedView sweetDetailedView;
    private SweetDetailedModel sweetDetailedModel;
    private SweetDetailedWireframe sweetDetailedWireframe;

    public SweetDetailedPresenterImpl(SweetDetailedView sweetDetailedView, SweetDetailedWireframe sweetDetailedWireframe, SweetDetailedModel sweetDetailedModel) {
        this.sweetDetailedView = sweetDetailedView;
        this.sweetDetailedWireframe = sweetDetailedWireframe;
        this.sweetDetailedModel = sweetDetailedModel;

    }

    @Override
    public Sweet findById(int id) {
        return sweetDetailedModel.findById(id);
    }

    @Override
    public void onViewInitialised() {
        sweetDetailedView.setOnMixClickHandler(this);
        sweetDetailedView.setOnRemoveClickHandler(this);
    }

    @Override
    public void onMixClicked(int id) {
        sweetDetailedView.mixShow(sweetDetailedModel.findById(id).manufacture());
    }

    @Override
    public void onRemoveClicked(int id) {
        sweetDetailedModel.remove(id);
        sweetDetailedWireframe.showListContent();
    }
}
