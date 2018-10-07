package com.mghelas.internship_playground.sweet_screen.detailed;

import com.mghelas.internship_playground.entity.Sweet;

public interface SweetDetailedPresenter extends MixClickHandler, RemoveClickHandler{
    void onViewInitialised();

    Sweet findById(int id);
}
