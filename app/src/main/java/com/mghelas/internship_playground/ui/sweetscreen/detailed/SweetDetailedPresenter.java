package com.mghelas.internship_playground.ui.sweetscreen.detailed;

public interface SweetDetailedPresenter extends MixClickHandler, RemoveClickHandler, SweetDetailedCallback{
    void onViewInitialised();

    void findById(int id);
}
