package com.mghelas.internship_playground.ui.sweetscreen.add.impl;

import android.os.AsyncTask;

import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddModel;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.SweetAdd;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.SweetAddCallback;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.SweetAddReturnCallback;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.impl.SweetAddImpl;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.IngredientsFetcher;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.IngredientsListCallback;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.IngredientsLoadCallback;

import java.util.List;

public class SweetAddModelImpl implements SweetAddModel, SweetAddCallback, IngredientsLoadCallback {

    private SweetAddReturnCallback sweetAddReturnCallback;
    private IngredientsListCallback ingredientsListCallback;
    private IngredientsFetcher ingredientsFetcher;
    private SweetDao sweetDao;

    public SweetAddModelImpl(IngredientsFetcher ingredientsFetcher, SweetDao sweetDao) {
        this.ingredientsFetcher = ingredientsFetcher;
        this.sweetDao = sweetDao;
    }

    @Override
    public void add(Sweet sweet) {
        SweetAdd sweetAdd = new SweetAddImpl(this, sweetDao);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
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
