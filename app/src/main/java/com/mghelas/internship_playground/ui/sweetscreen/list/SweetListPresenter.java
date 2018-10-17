package com.mghelas.internship_playground.ui.sweetscreen.list;

import com.mghelas.internship_playground.network.NetworkState;

public interface SweetListPresenter extends ItemClickHandler, SweetListCallback, DeleteClickHandler, SwipeHandler {
    void onViewInitialised();
}
