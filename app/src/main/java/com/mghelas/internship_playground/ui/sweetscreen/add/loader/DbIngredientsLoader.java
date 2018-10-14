package com.mghelas.internship_playground.ui.sweetscreen.add.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.mghelas.internship_playground.storage.dao.impl.IngredientDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.IngredientDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Ingredient;

import java.util.List;

public class DbIngredientsLoader extends AsyncTaskLoader<List<Ingredient>> implements IngredientsFetcher {
    private IngredientDao ingredientDao;

    public DbIngredientsLoader(@NonNull Context context) {
        super(context);
        ingredientDao = new IngredientDaoImpl();
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
