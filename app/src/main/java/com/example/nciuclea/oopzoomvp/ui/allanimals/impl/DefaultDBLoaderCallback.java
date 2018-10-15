package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;

import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataLoadCallback;
import com.example.nciuclea.oopzoomvp.ui.allanimals.loaders.DBDataLoader;

import java.util.List;

public class DefaultDBLoaderCallback implements LoaderManager.LoaderCallbacks<List<Animal>> {

    private final DataLoadCallback<List<Animal>> dataLoadCallback;
    private final DBDataLoader dbDataLoader;

    public DefaultDBLoaderCallback(DBDataLoader dbDataLoader, DataLoadCallback<List<Animal>> dataLoadCallback) {
        this.dataLoadCallback = dataLoadCallback;
        this.dbDataLoader = dbDataLoader;
    }

    @NonNull
    @Override
    public Loader<List<Animal>> onCreateLoader(int i, @Nullable Bundle bundle) {
        Log.d("PROF_LOG", "onCreateLoader from LoaderManager callbacks is called");
        return dbDataLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Animal>> loader, List<Animal> animalList) {
        dataLoadCallback.onDataLoaded(animalList);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Animal>> loader) {

    }
}
