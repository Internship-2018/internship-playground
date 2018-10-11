package com.mghelas.internship_playground.sweetscreen.list;

import com.mghelas.internship_playground.entity.Sweet;

import java.util.List;

public interface SweetListPresenter extends ItemClickHandler, SweetListCallback {
    void onViewInitialised();

    void getAllSweets();
}
