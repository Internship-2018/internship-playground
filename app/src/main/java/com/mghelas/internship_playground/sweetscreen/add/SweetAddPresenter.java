package com.mghelas.internship_playground.sweetscreen.add;

import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAddReturnCallback;
import com.mghelas.internship_playground.sweetscreen.add.loader.IngredientsListCallback;
import com.mghelas.internship_playground.sweetscreen.add.loader.IngredientsLoadCallback;

import java.util.List;

public interface SweetAddPresenter extends AddClickHandler, SweetTypeRadioHandler, SweetAddReturnCallback, IngredientsListCallback {
    void viewInitialized();

    void add(Sweet sweet);

    void getAllIngredients();
}
