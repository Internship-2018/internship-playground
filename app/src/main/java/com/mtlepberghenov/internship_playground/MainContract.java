package com.mtlepberghenov.internship_playground;

import com.mtlepberghenov.internship_playground.base.BaseMvpPresenter;
import com.mtlepberghenov.internship_playground.base.BaseView;

public interface MainContract {

    interface View extends BaseView {

    }

    interface Presenter extends BaseMvpPresenter<MainContract.View> {


    }
}
