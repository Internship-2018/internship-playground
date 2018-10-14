package com.mghelas.internship_playground.ui.sweetscreen.add;

import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.SweetAddReturnCallback;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.IngredientsListCallback;

public interface SweetAddPresenter extends AddClickHandler, SweetAddReturnCallback, IngredientsListCallback {
    void viewInitialized();

    void add(Sweet sweet);

    void getAllIngredients();
}
