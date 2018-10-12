package com.mghelas.internship_playground.ui.sweetscreen.add.loader.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.DbIngredientsLoader;
import com.mghelas.internship_playground.ui.sweetscreen.add.loader.IngredientsLoadCallback;

import java.util.List;

public class IngredientsLoadCallbackImpl implements LoaderManager.LoaderCallbacks<List<Ingredient>> {

    private DbIngredientsLoader dbIngredientsLoader;
    private IngredientsLoadCallback ingredientsLoadCallback;

    public IngredientsLoadCallbackImpl(DbIngredientsLoader dbIngredientsLoader, IngredientsLoadCallback ingredientsLoadCallback) {
        this.dbIngredientsLoader = dbIngredientsLoader;
        this.ingredientsLoadCallback = ingredientsLoadCallback;
    }

    @NonNull
    @Override
    public Loader<List<Ingredient>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return dbIngredientsLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Ingredient>> loader, List<Ingredient> ingredients) {
        ingredientsLoadCallback.onIngredientsLoaded(ingredients);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Ingredient>> loader) {

    }
}
