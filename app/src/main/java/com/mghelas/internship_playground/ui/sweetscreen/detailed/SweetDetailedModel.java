package com.mghelas.internship_playground.ui.sweetscreen.detailed;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;

public interface SweetDetailedModel {
    void findById(int id);

    void remove(int id);

    void onRemoveCalled(int id);

    void setSweetDetailedCallback(SweetDetailedCallback sweetDetailedCallback);

    void setSweetServiceCall(SweetServiceCall sweetServiceCall);
}
