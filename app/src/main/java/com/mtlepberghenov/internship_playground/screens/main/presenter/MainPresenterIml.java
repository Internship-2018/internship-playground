package com.mtlepberghenov.internship_playground.screens.main.presenter;

import com.mtlepberghenov.internship_playground.base.BasePresenter;
import com.mtlepberghenov.internship_playground.screens.main.view.MainView;

public class MainPresenterIml extends BasePresenter<MainView>
        implements MainPresenter {


    @Override
    public void onShowStoreBtnClicked() {
        getView().onStartCarListFragment();
    }
}
