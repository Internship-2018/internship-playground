package com.example.nciuclea.oopzoo.ui.start.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.example.nciuclea.oopzoo.storage.model.Animal;
import com.example.nciuclea.oopzoo.ui.start.DataFetcher;

import java.util.Collections;
import java.util.List;


public class DbDataLoader extends AsyncTaskLoader<List<Animal>> implements DataFetcher {

    public DbDataLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<Animal> loadInBackground() {
        //TODO load from DB
        return Collections.singletonList(new Animal());
    }

    @Override
    public void fetchData() {
        onContentChanged();
    }
}
