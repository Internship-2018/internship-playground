package com.mtlepberghenov.internship_playground.screens.vehiclelist.presenter;

import android.util.Log;

import com.mtlepberghenov.internship_playground.base.BasePresenter;
import com.mtlepberghenov.internship_playground.model.MainModel;
import com.mtlepberghenov.internship_playground.screens.vehiclelist.view.VehicleListView;

public class VehicleListPresenterImpl extends BasePresenter<VehicleListView>
        implements VehicleListPresenter {

    private MainModel model;

    public VehicleListPresenterImpl(MainModel model) {

        this.model = model;
    }

    @Override
    public void onRecyclerViewIsReady() {
        Log.d("debug", "onRecyclerViewIsReady: " + getView());
        getView().setVehicleListToAdapter(model.getVehicleList());
    }
}
