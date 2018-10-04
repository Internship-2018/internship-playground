package com.mtlepberghenov.internship_playground.screens.main.presenter;

import com.mtlepberghenov.internship_playground.base.BaseMvpPresenter;
import com.mtlepberghenov.internship_playground.screens.main.view.MainView;

public interface MainPresenter extends BaseMvpPresenter<MainView> {

  void onClicked();
}
