package com.mghelas.internship_playground.sweetscreen.add.loader;

import com.mghelas.internship_playground.entity.Ingredient;

import java.util.List;

public interface IngredientsListCallback {
    void onIngredientsLoaded(List<Ingredient> ingredients);
}
