package com.example.nciuclea.oopzoomvp.ui.allanimals.loaders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.datasource.DBHelper;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataFetcher;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBDataLoader extends AsyncTaskLoader<List<Animal>> implements DataFetcher {

    private DBHelper dbHelper;
    private Dao<Animal, Integer> animalDao;

    public DBDataLoader(@NonNull Context context) {
        super(context);
        dbHelper = OpenHelperManager.getHelper(getContext(), DBHelper.class);
        try {
            animalDao = dbHelper.getAnimalDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    @Override
    public List<Animal> loadInBackground() {
        Log.d("PROF_LOG", "LoadInBackground called");

        try {
            return new ArrayList<>(animalDao.queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void fetchData() {
        Log.d("PROF_LOG", "fetchData() called");

        if (isStarted()) {
            onContentChanged();
        } else {
            forceLoad();
        }
    }
}
