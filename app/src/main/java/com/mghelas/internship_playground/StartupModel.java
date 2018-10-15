package com.mghelas.internship_playground;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public interface StartupModel {
    void updateData();

    void syncDb(List<Sweet> sweets);

    void setSweetServiceCall(SweetServiceCall sweetServiceCall);
}
