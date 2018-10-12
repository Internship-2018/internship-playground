package com.mghelas.internship_playground.sweetscreen.detailed.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.datasource.DbHelper;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.detailed.DetailedFetcher;

public class DbDetailedLoader extends AsyncTaskLoader<Sweet> implements DetailedFetcher {
    private int id;

    public DbDetailedLoader(@NonNull Context context) {
        super(context);
    }

    @Override
    public void fetchData(int id) {
        this.id = id;
        if (isStarted()) {
            onContentChanged();
        } else {
            forceLoad();
        }
    }

    @Nullable
    @Override
    public Sweet loadInBackground() {
        return DbHelper.getInstance(getContext()).findSweetById(id);
    }
}
