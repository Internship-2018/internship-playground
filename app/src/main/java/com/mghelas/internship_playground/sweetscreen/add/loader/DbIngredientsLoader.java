package com.mghelas.internship_playground.sweetscreen.add.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.mghelas.internship_playground.datasource.DbHelper;
import com.mghelas.internship_playground.entity.Ingredient;

import java.util.List;

public class DbIngredientsLoader extends AsyncTaskLoader<List<Ingredient>> implements IngredientsFetcher {
    public DbIngredientsLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<Ingredient> loadInBackground() {
        return DbHelper.getInstance(getContext()).getAllIngredients();
    }

    @Override
    public void fetchIngredients() {
        if (isStarted()) {
            onContentChanged();
        } else {
            forceLoad();
        }
    }
}
