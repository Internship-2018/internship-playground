package com.mghelas.internship_playground.ui.sweetscreen.detailed.impl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.DetailedLoadCallback;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.loader.DbDetailedLoader;

public class DbDetailedLoaderCallbackImpl implements LoaderManager.LoaderCallbacks<Sweet> {

    private DbDetailedLoader dbDetailedLoader;
    private DetailedLoadCallback detailedLoadCallback;

    public DbDetailedLoaderCallbackImpl(DbDetailedLoader dbDetailedLoader, DetailedLoadCallback detailedLoadCallback) {
        this.dbDetailedLoader = dbDetailedLoader;
        this.detailedLoadCallback = detailedLoadCallback;
    }

    @NonNull
    @Override
    public Loader<Sweet> onCreateLoader(int i, @Nullable Bundle bundle) {
        return dbDetailedLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Sweet> loader, Sweet sweet) {
        detailedLoadCallback.onDataLoaded(sweet);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Sweet> loader) {

    }
}
