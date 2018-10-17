package com.mghelas.internship_playground.ui.sweetscreen.detailed.impl;


import com.mghelas.internship_playground.network.NetworkConectivity;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedCallback;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedModel;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedView;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedWireframe;

public class SweetDetailedPresenterImpl implements SweetDetailedPresenter, SweetDetailedCallback {
    private SweetDetailedView sweetDetailedView;
    private SweetDetailedModel sweetDetailedModel;
    private SweetDetailedWireframe sweetDetailedWireframe;
    private Sweet sweet;
    private NetworkConectivity networkConectivity;

    public SweetDetailedPresenterImpl(SweetDetailedView sweetDetailedView, SweetDetailedWireframe sweetDetailedWireframe, SweetDetailedModel sweetDetailedModel, NetworkConectivity networkConectivity) {
        this.sweetDetailedView = sweetDetailedView;
        this.sweetDetailedWireframe = sweetDetailedWireframe;
        this.sweetDetailedModel = sweetDetailedModel;
        this.networkConectivity = networkConectivity;
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
        if (networkConectivity.isNetworkConnected()) {
            sweetDetailedModel.remove(id);
        } else {
            sweetDetailedView.showError("No internet connection");
        }
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
