package com.example.nciuclea.oopzoo.ui.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import com.example.nciuclea.oopzoo.storage.model.Animal;
import com.example.nciuclea.oopzoo.ui.start.impl.DefaultDbLoaderCallback;
import com.example.nciuclea.oopzoo.ui.start.impl.DefaultStartModel;
import com.example.nciuclea.oopzoo.ui.start.impl.DefaultStartPresenter;
import com.example.nciuclea.oopzoo.ui.start.impl.DefaultStartView;
import com.example.nciuclea.oopzoo.ui.start.impl.DefaultStartWireframe;
import com.example.nciuclea.oopzoo.ui.start.loader.DbDataLoader;

import java.util.List;


public class StartActivity extends AppCompatActivity {

    private static final int LOADER_ID = 10001;
    private StartNativeView startNativeView;
    private StartPresenter startPresenter;
    private Loader<List<Animal>> listLoader;
    private StartModel startModel;
    protected LoaderManager.LoaderCallbacks<List<Animal>> listLoaderCallbacks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DefaultStartView view = new DefaultStartView();
        final DbDataLoader dbDataLoader = new DbDataLoader(this);
        listLoader = new DbDataLoader(this);
        final DefaultStartModel model = new DefaultStartModel(dbDataLoader);
        startModel = model;
        listLoaderCallbacks = new DefaultDbLoaderCallback(dbDataLoader, model);
        startNativeView = view;
        startPresenter = new DefaultStartPresenter(view, startModel, new DefaultStartWireframe(this));
        setContentView(startNativeView.getLayout());
        LoaderManager.getInstance(this).initLoader(LOADER_ID, null, listLoaderCallbacks);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        startNativeView.initView(this);
        startPresenter.onViewInitialised();
    }
}
