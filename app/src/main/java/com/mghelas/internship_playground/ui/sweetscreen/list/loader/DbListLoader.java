package com.mghelas.internship_playground.ui.sweetscreen.list.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.mghelas.internship_playground.storage.dao.impl.SweetDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.ListFetcher;

import java.util.List;

public class DbListLoader extends AsyncTaskLoader<List<Sweet>> implements ListFetcher {

    SweetDao sweetDao;

    public DbListLoader(@NonNull Context context) {
        super(context);
        sweetDao = new SweetDaoImpl();
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
