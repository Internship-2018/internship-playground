package com.mghelas.internship_playground.ui.sweetscreen.detailed.loader;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetRemover;

public class RemoveSweetLoader extends AsyncTaskLoader<Integer> implements SweetRemover {

    private Sweet sweet;
    private SweetDao sweetDao;

    public RemoveSweetLoader(@NonNull Context context, SweetDao sweetDao) {
        super(context);
        this.sweetDao = sweetDao;
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
