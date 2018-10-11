package com.mghelas.internship_playground.sweetscreen.detailed.impl;


import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.detailed.DetailedLoadCallback;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedCallback;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedPresenter;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedModel;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedView;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedWireframe;

public class SweetDetailedPresenterImpl implements SweetDetailedPresenter, SweetDetailedCallback {
    private SweetDetailedView sweetDetailedView;
    private SweetDetailedModel sweetDetailedModel;
    private SweetDetailedWireframe sweetDetailedWireframe;
    private Sweet sweet;

    public SweetDetailedPresenterImpl(SweetDetailedView sweetDetailedView, SweetDetailedWireframe sweetDetailedWireframe, SweetDetailedModel sweetDetailedModel) {
        this.sweetDetailedView = sweetDetailedView;
        this.sweetDetailedWireframe = sweetDetailedWireframe;
        this.sweetDetailedModel = sweetDetailedModel;

    }

    @Override
    public void findById(int id) {
        sweetDetailedModel.findById(id);
    }

    @Override
    public void onViewInitialised() {
        sweetDetailedView.setOnMixClickHandler(this);
        sweetDetailedView.setOnRemoveClickHandler(this);
    }

    @Override
    public void onMixClicked() {
        sweetDetailedView.mixShow(sweet.manufacture());
    }

    @Override
    public void onRemoveClicked(int id) {
        sweetDetailedModel.remove(id);
    }


    @Override
    public void onDetailedLoaded(Sweet sweet) {

        this.sweet = sweet;
        sweetDetailedView.bindData(sweet);
    }

    @Override
    public void onSweetRemoved(int id) {
        sweetDetailedWireframe.showListContent();
    }
}
