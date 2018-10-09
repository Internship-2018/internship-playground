package com.mghelas.internship_playground.sweetscreen.add;

import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.entity.Sweet;

import java.util.List;

public interface SweetAddModel {
    long add(Sweet sweet);

    List<Ingredient> getAllIngredients();
}
