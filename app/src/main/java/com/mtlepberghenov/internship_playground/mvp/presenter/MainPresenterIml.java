package com.mtlepberghenov.internship_playground.mvp.presenter;

import com.mtlepberghenov.internship_playground.base.BasePresenter;
import com.mtlepberghenov.internship_playground.mvp.view.MainView;

public class MainPresenterIml extends BasePresenter<MainView>
        implements Presenter {


    @Override
    public void onShowStoreBtnClicked() {
        getView().onStartCarListFragment();
    }
}
