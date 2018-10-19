package com.mghelas.internship_playground.ui.sweetscreen.list.loader;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.ListFetcher;

import java.util.List;

public class DbListLoader extends AsyncTaskLoader<List<Sweet>> implements ListFetcher {

    SweetDao sweetDao;

    public DbListLoader(@NonNull Context context, SweetDao sweetDao) {
        super(context);
        this.sweetDao = sweetDao;
    }

    @Nullable
    @Override
    public List<Sweet> loadInBackground() {
        return sweetDao.getAll();
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
