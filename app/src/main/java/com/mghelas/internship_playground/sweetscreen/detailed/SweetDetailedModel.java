package com.mghelas.internship_playground.sweetscreen.detailed;

import com.mghelas.internship_playground.entity.Sweet;

public interface SweetDetailedModel {
    void findById(int id);

    void remove(int id);

    void setSweetDetailedCallback(SweetDetailedCallback sweetDetailedCallback);
}
