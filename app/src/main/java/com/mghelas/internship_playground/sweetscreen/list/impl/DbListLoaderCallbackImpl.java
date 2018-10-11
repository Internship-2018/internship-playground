package com.mghelas.internship_playground.sweetscreen.list.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.list.ListLoadCallback;
import com.mghelas.internship_playground.sweetscreen.list.loader.DbListLoader;

import java.util.List;

public class DbListLoaderCallbackImpl implements LoaderManager.LoaderCallbacks<List<Sweet>> {
    private final ListLoadCallback<List<Sweet>> listLoadCallback;
    private final DbListLoader dbDataLoader;

    public DbListLoaderCallbackImpl(DbListLoader dbDataLoader, ListLoadCallback<List<Sweet>> listLoadCallback) {
        this.listLoadCallback = listLoadCallback;
        this.dbDataLoader = dbDataLoader;
    }

    @NonNull
    @Override
    public Loader<List<Sweet>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return dbDataLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Sweet>> loader, List<Sweet> sweets) {
        listLoadCallback.onDataLoaded(sweets);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Sweet>> loader) {
    }
}
