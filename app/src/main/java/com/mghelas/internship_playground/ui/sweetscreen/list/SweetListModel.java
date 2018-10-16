package com.mghelas.internship_playground.ui.sweetscreen.list;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public interface SweetListModel {
    void getAll();

    void deleteByConfectionerName(String name);

    void onDeleteCalled(String name);

    void setSweetServiceCall(SweetServiceCall sweetServiceCall);

    void setSweetListCallback(SweetListCallback sweetListCallback);
}
