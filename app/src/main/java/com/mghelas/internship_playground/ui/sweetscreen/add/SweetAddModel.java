package com.mghelas.internship_playground.ui.sweetscreen.add;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.storage.entity.Sweet;

public interface SweetAddModel {
    void add(Sweet sweet);

    void getAllIngredients();

    void onCreateCalled(Sweet sweet);

    void setSweetServiceCall(SweetServiceCall sweetServiceCall);
}
