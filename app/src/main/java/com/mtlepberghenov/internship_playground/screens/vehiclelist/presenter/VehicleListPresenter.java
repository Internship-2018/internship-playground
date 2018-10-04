package com.mtlepberghenov.internship_playground.screens.vehiclelist.presenter;

import com.mtlepberghenov.internship_playground.base.BaseMvpPresenter;
import com.mtlepberghenov.internship_playground.screens.vehiclelist.view.VehicleListView;

public interface VehicleListPresenter extends BaseMvpPresenter<VehicleListView> {

  void onRecyclerViewIsReady();
}
