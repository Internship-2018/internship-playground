package com.mghelas.internship_playground.sweetscreen.detailed.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetRemover;

public class RemoveSweetLoader extends AsyncTaskLoader<Integer> implements SweetRemover {
    public RemoveSweetLoader(@NonNull Context context) {
        super(context);
    }

    private Integer id;

    @Nullable
    @Override
    public Integer loadInBackground() {
        return App.getInstance().getDbHelper().remove(id);
    }

    @Override
    public void removeSweet(int id) {
        this.id = id;
        if (isStarted()) {
            onContentChanged();
        } else {
            forceLoad();
        }
    }
}
