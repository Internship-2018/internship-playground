package com.mghelas.internship_playground.ui.sweetscreen.add.loader;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.mghelas.internship_playground.storage.dao.intf.IngredientDao;
import com.mghelas.internship_playground.storage.entity.Ingredient;

import java.util.List;

public class DbIngredientsLoader extends AsyncTaskLoader<List<Ingredient>> implements IngredientsFetcher {
    private IngredientDao ingredientDao;

    public DbIngredientsLoader(@NonNull Context context, IngredientDao ingredientDao) {
        super(context);
        this.ingredientDao = ingredientDao;
    }

    @Nullable
    @Override
    public List<Ingredient> loadInBackground() {
        return ingredientDao.getAll();
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
