package com.mghelas.internship_playground.ui.sweetscreen.detailed.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.mghelas.internship_playground.storage.dao.impl.SweetDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.DetailedFetcher;

public class DbDetailedLoader extends AsyncTaskLoader<Sweet> implements DetailedFetcher {
    private int id;

    SweetDao sweetDao;

    public DbDetailedLoader(@NonNull Context context, SweetDao sweetDao) {
        super(context);
        this.sweetDao = sweetDao;
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
        Sweet sweet = sweetDao.findById(id);
        Log.d("sweet ingredients", sweet.toString());
        return sweet;
    }
}
