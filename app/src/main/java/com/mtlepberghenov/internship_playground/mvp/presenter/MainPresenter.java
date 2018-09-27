package com.mtlepberghenov.internship_playground.mvp.presenter;

import com.mtlepberghenov.internship_playground.base.BaseMvpPresenter;
import com.mtlepberghenov.internship_playground.mvp.view.MainView;

public interface MainPresenter extends BaseMvpPresenter<MainView> {

    void onShowStoreBtnClicked();
}
