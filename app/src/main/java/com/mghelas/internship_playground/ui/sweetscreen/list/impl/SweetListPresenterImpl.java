package com.mghelas.internship_playground.ui.sweetscreen.list.impl;

import com.mghelas.internship_playground.network.NetworkConectivity;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListModel;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListView;
import com.mghelas.internship_playground.ui.sweetscreen.list.SweetListWireframe;

import java.util.List;

public class SweetListPresenterImpl implements SweetListPresenter {
    private SweetListView sweetListView;
    private SweetListWireframe sweetListWireframe;
    private SweetListModel sweetModel;
    private NetworkConectivity networkConectivity;


    public SweetListPresenterImpl(SweetListView sweetListView, SweetListWireframe sweetListWireframe, SweetListModel sweetListModel, NetworkConectivity networkConectivity) {
        this.sweetListView = sweetListView;
        this.sweetListWireframe = sweetListWireframe;
        this.sweetModel = sweetListModel;
        this.networkConectivity = networkConectivity;
    }


    @Override
    public void onViewInitialised() {
        sweetListView.setOnItemClickHandler(this);
        sweetListView.setOnDeleteClickHandler(this);
        sweetListView.setOnSwipeHandler(this);
        sweetModel.getAll();
    }

    @Override
    public void onItemClicked(int id) {
        sweetListWireframe.showDetailedContent(id);
    }


    @Override
    public void onListLoaded(List<Sweet> sweets) {
        sweetListView.bindData(sweets);
    }

    @Override
    public void onApiFailure(Throwable throwable) {
        sweetListView.showError("Error");
    }

    @Override
    public void onDeleteClicked(String name) {
        if (networkConectivity.isNetworkConnected()) {
            sweetModel.deleteByConfectionerName(name);
        } else {
            sweetListView.showError("No internet connection");
        }
    }

    @Override
    public void onSwiped() {
        if (networkConectivity.isNetworkConnected()) {
            sweetModel.updateData();
        } else {
            sweetListView.showError("No internet connection");
        }
    }
}
