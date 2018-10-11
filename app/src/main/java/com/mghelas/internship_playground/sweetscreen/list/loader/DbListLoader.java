package com.mghelas.internship_playground.sweetscreen.list.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.list.ListFetcher;

import java.util.List;

public class DbListLoader extends AsyncTaskLoader<List<Sweet>> implements ListFetcher {

    public DbListLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<Sweet> loadInBackground() {
        return App.getInstance().getDbHelper().getAllSweets();
    }


    @Override
    public void fetchData() {

        if (isStarted()) {
            onContentChanged();
        } else {
            forceLoad();
        }
    }
}
