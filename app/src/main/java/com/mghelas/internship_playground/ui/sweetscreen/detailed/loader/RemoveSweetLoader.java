package com.mghelas.internship_playground.ui.sweetscreen.detailed.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.mghelas.internship_playground.storage.dao.impl.SweetDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetRemover;

public class RemoveSweetLoader extends AsyncTaskLoader<Integer> implements SweetRemover {

    private Sweet sweet;
    private SweetDao sweetDao;

    public RemoveSweetLoader(@NonNull Context context) {
        super(context);
        sweetDao = new SweetDaoImpl();
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        return sweetDao.delete(sweet);
    }

    @Override
    public void removeSweet(int id) {
        sweet = sweetDao.findById(id);
        if (isStarted()) {
            onContentChanged();
        } else {
            forceLoad();
        }
    }
}
