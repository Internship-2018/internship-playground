package com.mtlepberghenov.internship_playground.base;

public abstract class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

    private V view;

    public V getView() {
        return view;
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public boolean isAttach() {
        return this.view != null;
    }
}
