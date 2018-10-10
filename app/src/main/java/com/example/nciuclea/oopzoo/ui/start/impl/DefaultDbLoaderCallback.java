package com.example.nciuclea.oopzoo.ui.start.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.example.nciuclea.oopzoo.storage.model.Animal;
import com.example.nciuclea.oopzoo.ui.start.DataLoadCallback;
import com.example.nciuclea.oopzoo.ui.start.loader.DbDataLoader;

import java.util.List;


public class DefaultDbLoaderCallback implements LoaderManager.LoaderCallbacks<List<Animal>> {

    private final DataLoadCallback<List<Animal>> dataLoadCallback;
    private final DbDataLoader dbDataLoader;

    public DefaultDbLoaderCallback(DbDataLoader dbDataLoader, DataLoadCallback<List<Animal>> dataLoadCallback) {
        this.dbDataLoader = dbDataLoader;
        this.dataLoadCallback = dataLoadCallback;
    }

    @NonNull
    @Override
    public Loader<List<Animal>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return dbDataLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Animal>> loader, List<Animal> animals) {
        dataLoadCallback.onDataLoaded(animals);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Animal>> loader) {

    }


}
