package com.mtlepberghenov.internship_playground.screens.carlist.presenter;

import com.mtlepberghenov.internship_playground.base.BaseMvpPresenter;
import com.mtlepberghenov.internship_playground.screens.carlist.view.CarListView;

public interface CarListPresenter extends BaseMvpPresenter<CarListView> {

    void onRecyclerViewIsReady();
}
