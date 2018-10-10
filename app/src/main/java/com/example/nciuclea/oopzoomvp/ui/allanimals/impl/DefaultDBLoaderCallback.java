package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataLoadCallback;
import com.example.nciuclea.oopzoomvp.ui.allanimals.loaders.DBDataLoader;

import java.util.List;

public class DefaultDBLoaderCallback implements LoaderManager.LoaderCallbacks<List<DBAnimal>> {

    private final DataLoadCallback<List<DBAnimal>> dataLoadCallback;
    private final DBDataLoader dbDataLoader;

    public DefaultDBLoaderCallback(DBDataLoader dbDataLoader, DataLoadCallback<List<DBAnimal>> dataLoadCallback) {
        this.dataLoadCallback = dataLoadCallback;
        this.dbDataLoader = dbDataLoader;
    }

    @NonNull
    @Override
    public Loader<List<DBAnimal>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return dbDataLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<DBAnimal>> loader, List<DBAnimal> dbAnimals) {
        dataLoadCallback.onDataLoaded(dbAnimals);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<DBAnimal>> loader) {

    }
}
