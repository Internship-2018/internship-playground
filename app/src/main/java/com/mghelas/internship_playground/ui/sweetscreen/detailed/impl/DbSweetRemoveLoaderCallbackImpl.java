package com.mghelas.internship_playground.ui.sweetscreen.detailed.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetRemovedCallback;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.loader.RemoveSweetLoader;

public class DbSweetRemoveLoaderCallbackImpl implements LoaderManager.LoaderCallbacks<Integer> {

    private RemoveSweetLoader removeSweetLoader;
    private SweetRemovedCallback sweetRemovedCallback;

    public DbSweetRemoveLoaderCallbackImpl(RemoveSweetLoader removeSweetLoader, SweetRemovedCallback sweetRemovedCallback) {
        this.removeSweetLoader = removeSweetLoader;
        this.sweetRemovedCallback = sweetRemovedCallback;
    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int i, @Nullable Bundle bundle) {
        return removeSweetLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer id) {
        sweetRemovedCallback.onDataRemoved(id);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {

    }
}
