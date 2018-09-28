package com.mtlepberghenov.internship_playground.screens.carlist.presenter;

import android.util.Log;

import com.mtlepberghenov.internship_playground.base.BasePresenter;
import com.mtlepberghenov.internship_playground.model.MainModel;
import com.mtlepberghenov.internship_playground.screens.carlist.view.CarListView;

public class CarListPresenterImpl extends BasePresenter<CarListView>
        implements CarListPresenter {

    private MainModel model;

    public CarListPresenterImpl(MainModel model) {

        this.model = model;
    }

    @Override
    public void onRecyclerViewIsReady() {
        Log.d("debug", "onRecyclerViewIsReady: " + getView());
        getView().setCarListToAdapter(model.getCarList());
    }
}
