package com.example.nciuclea.oopzoomvp.ui.allanimals.loaders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import com.example.nciuclea.oopzoomvp.App;
import com.example.nciuclea.oopzoomvp.database.DatabaseHelper;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataFetcher;

import java.util.ArrayList;
import java.util.List;

public class DBDataLoader extends AsyncTaskLoader<List<DBAnimal>> implements DataFetcher {

    public DBDataLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<DBAnimal> loadInBackground() {
        DatabaseHelper db = App.getInstance().getDatabaseHelper();
        return new ArrayList<>(db.getAllAnimals());
    }

    @Override
    public void fetchData() {
        onContentChanged();
    }
}
