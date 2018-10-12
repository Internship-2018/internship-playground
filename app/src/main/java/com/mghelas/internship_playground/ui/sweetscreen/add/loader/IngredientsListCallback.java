package com.mghelas.internship_playground.ui.sweetscreen.add.loader;

import com.mghelas.internship_playground.storage.entity.Ingredient;

import java.util.List;

public interface IngredientsListCallback {
    void onIngredientsLoaded(List<Ingredient> ingredients);
}
