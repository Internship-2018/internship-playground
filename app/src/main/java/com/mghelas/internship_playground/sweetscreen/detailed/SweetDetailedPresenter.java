package com.mghelas.internship_playground.sweetscreen.detailed;

import com.mghelas.internship_playground.entity.Sweet;

public interface SweetDetailedPresenter extends MixClickHandler, RemoveClickHandler, SweetDetailedCallback{
    void onViewInitialised();

    void findById(int id);
}
