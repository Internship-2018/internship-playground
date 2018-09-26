package com.mtlepberghenov.internship_playground.base;

public interface BaseMvpPresenter<V extends BaseView> {

    void attach(V view);

    void detach();

    boolean isAttach();
}
