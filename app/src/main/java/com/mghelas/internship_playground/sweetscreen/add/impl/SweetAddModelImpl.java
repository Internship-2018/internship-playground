package com.mghelas.internship_playground.sweetscreen.add.impl;

import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.add.SweetAddModel;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAdd;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAddCallback;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAddReturnCallback;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.impl.SweetAddImpl;
import com.mghelas.internship_playground.sweetscreen.add.loader.IngredientsFetcher;
import com.mghelas.internship_playground.sweetscreen.add.loader.IngredientsListCallback;
import com.mghelas.internship_playground.sweetscreen.add.loader.IngredientsLoadCallback;

import java.util.List;

public class SweetAddModelImpl implements SweetAddModel, SweetAddCallback, IngredientsLoadCallback {

    private SweetAddReturnCallback sweetAddReturnCallback;
    private IngredientsListCallback ingredientsListCallback;
    private IngredientsFetcher ingredientsFetcher;

    public SweetAddModelImpl(IngredientsFetcher ingredientsFetcher) {
        this.ingredientsFetcher = ingredientsFetcher;
    }

    @Override
    public void add(Sweet sweet) {
        SweetAdd sweetAdd = new SweetAddImpl(this);
        sweetAdd.add(sweet);
    }

    @Override
    public void getAllIngredients() {
        ingredientsFetcher.fetchIngredients();
    }


    @Override
    public void onSweetAdded() {
        sweetAddReturnCallback.goToList();
    }

    @Override
    public void setOnSweetAddReturnCallback(SweetAddReturnCallback sweetAddReturnCallback) {
        this.sweetAddReturnCallback = sweetAddReturnCallback;
    }

    public void setIngredientsListCallback(IngredientsListCallback ingredientsListCallback) {
        this.ingredientsListCallback = ingredientsListCallback;
    }

    @Override
    public void onIngredientsLoaded(List<Ingredient> ingredients) {
        ingredientsListCallback.onIngredientsLoaded(ingredients);
    }
}
