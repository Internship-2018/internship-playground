package com.mghelas.internship_playground.ui.sweetscreen.list;

public interface SweetListPresenter extends ItemClickHandler, SweetListCallback {
    void onViewInitialised();

    void getAllSweets();
}
