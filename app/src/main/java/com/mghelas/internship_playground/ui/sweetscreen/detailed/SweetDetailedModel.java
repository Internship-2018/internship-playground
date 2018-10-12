package com.mghelas.internship_playground.ui.sweetscreen.detailed;

public interface SweetDetailedModel {
    void findById(int id);

    void remove(int id);

    void setSweetDetailedCallback(SweetDetailedCallback sweetDetailedCallback);
}
